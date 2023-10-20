import dao.*;
import entities.*;
import entities.Enum.TipoPeriodicita;
import utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        EntityManager em= JpaUtils.getEmf().createEntityManager();
        try {
            /////////////////CREAZIONE LIBRI E RIVISTE//////////////////////
//            LibroDAO libroDAO = new LibroDAO(em);
//            RivistaDAO rivistaDAO=  new RivistaDAO(em);
//            Libro libro1 = new Libro(1234567890L, "Il mio libro", 2020, 200, "Romanzo", "Autore del libro");
//            Libro libro2 = new Libro(1234234890L, "Libro 2", 2018, 200, "Romanzo", "Autore 2");
//            Libro libro3 = new Libro(9876543210L, "Libro 3", 2022, 250, "Fantascienza", "Autore 3");
//            Rivista rivista1 = new Rivista(1111222233L, "Rivista 1", 2019, 50, TipoPeriodicita.MENSILE);
//            Rivista rivista2 = new Rivista(4444555566L, "Rivista 2", 2022, 40, TipoPeriodicita.SETTIMANALE);
//            Rivista rivista3 = new Rivista(7777888899L, "Rivista 3", 2022, 60, TipoPeriodicita.SEMESTRALE);
//            libroDAO.save(libro1);
//            libroDAO.save(libro2);
//            libroDAO.save(libro3);
//            rivistaDAO.save(rivista1);
//            rivistaDAO.save(rivista2);
//            rivistaDAO.save(rivista3);
//
//            //////////////////////sout Libri//////////////////////////////
//            System.out.println("Libro creato e aggiunto al database: " + libro1);
//            System.out.println("Libro creato e aggiunto al database: " + libro2);
//            System.out.println("Libro creato e aggiunto al database: " + libro3);
//            System.out.println("Rivista creata e aggiunto al database: " + rivista1);
//            System.out.println("Rivista creata e aggiunto al database: " + rivista2);
//            System.out.println("Rivista creata e aggiunto al database: " + rivista3);







            ////////////////RICERCA PER ISBN/////////////////////////////////////////////
//            Query pubblicazioneQuery = em.createNamedQuery("Pubblicazione.findByCodiceISBN");
//            pubblicazioneQuery.setParameter("isbn", 1234567890L);
//            Pubblicazione elemento = (Pubblicazione) pubblicazioneQuery.getSingleResult();
//            if (elemento!= null){
//                if(elemento instanceof Libro){
//                    Libro libroTrovato = (Libro) elemento;
//                    System.out.println("L'elemento trovato è un "+ libroTrovato + " ,titolo : " +libroTrovato.getTitolo() + ", Anno di Pubblicazione: "  +libroTrovato.getAnnoPubblicazione()+ ", codice ISBN:  " +libroTrovato.getCodiceISBN());
//                }else if (elemento instanceof Rivista){
//                    Rivista rivistaTrovata = (Rivista) elemento;
//                    System.out.println("L'elemento trovato è una " + rivistaTrovata +" titolo: "+  rivistaTrovata.getTitolo()+ " codice: "+ rivistaTrovata.getCodiceISBN() + " numero pagine:  "+  rivistaTrovata.getNumeroPagine() + "  annoPubblicazione:  "+  rivistaTrovata.getAnnoPubblicazione());
//                }
//            }else {
//                System.out.println("Non è stato trovato un elemento con questo ISBN");
//            }






            ////////////////////RICERCA PER ANNO/////////////////////////////
//            Query query = em.createNamedQuery("Pubblicazione.findByAnnoPubblicazione");
//            query.setParameter("annoPubblicazione", 2022);
//            List<Pubblicazione> pubblicazioni = query.getResultList();
//
//            if (!pubblicazioni.isEmpty()) {
//                System.out.println("Pubblicazioni trovate per l'anno " + "2022" + ":");
//                for (Pubblicazione pubblicazione : pubblicazioni) {
//                    if (pubblicazione instanceof Libro) {
//                        Libro libroPerAnno = (Libro) pubblicazione;
//                        System.out.println("Libro: " + libroPerAnno.getTitolo() + ", Autore: " + libroPerAnno.getAutore());
//                    } else if (pubblicazione instanceof Rivista) {
//                        Rivista rivistaPerAnno = (Rivista) pubblicazione;
//                        System.out.println("Rivista: " + rivistaPerAnno.getTitolo() + ", Tipo di Periodicità: " + rivistaPerAnno.getTipoPeriodicita());
//                    }
//                }
//            } else {
//                System.out.println("Nessuna pubblicazione trovata per l'anno " + "2022");
//            }



            //////////////////////////RICERCA PER AUTORE///////////////////////////////////
//            Query query = em.createNamedQuery("Pubblicazione.findByAutore");
//            query.setParameter("autore","Autore del libro" );
//
//            List<Pubblicazione> pubblicazioni = query.getResultList();
//
//            if (!pubblicazioni.isEmpty()) {
//                System.out.println("Pubblicazioni trovate per l'autore " + "Autore del libro"+ ":");
//                for (Pubblicazione pubblicazione : pubblicazioni) {
//                    if (pubblicazione instanceof Libro) {
//                        Libro libroPerAutore = (Libro) pubblicazione;
//                        System.out.println("Libro: " + libroPerAutore.getTitolo() + ", Autore: " + libroPerAutore.getAutore());
//                    } else if (pubblicazione instanceof Rivista) {
//                        Rivista rivistaPerAutore = (Rivista) pubblicazione;
//                        System.out.println("Rivista: " + rivistaPerAutore.getTitolo() + ", Tipo di Periodicità: " + rivistaPerAutore.getTipoPeriodicita());
//                    }
//                }
//            } else {
//                System.out.println("Nessuna pubblicazione trovata per l'autore " + "Autore del libro");
//            }




            ////////////////////////RICERCA PER TITOLO O PARTE///////////////////////////////////
//            Query query = em.createNamedQuery("Pubblicazione.findByTitolo");
//            query.setParameter("titolo", "%" + "mio" + "%");
//
//            List<Pubblicazione> pubblicazioni = query.getResultList();
//
//            if (!pubblicazioni.isEmpty()) {
//                System.out.println("Pubblicazioni trovate con il titolo contenente: " + "mio" + ":");
//                for (Pubblicazione pubblicazione : pubblicazioni) {
//                    if (pubblicazione instanceof Libro) {
//                        Libro libroPerTitolo = (Libro) pubblicazione;
//                        System.out.println("Libro: " + libroPerTitolo.getTitolo() + ", Autore: " + libroPerTitolo.getAutore());
//                    } else if (pubblicazione instanceof Rivista) {
//                        Rivista rivistaPerTitolo = (Rivista) pubblicazione;
//                        System.out.println("Rivista: " + rivistaPerTitolo.getTitolo() + ", Tipo di Periodicità: " + rivistaPerTitolo.getTipoPeriodicita());
//                    }
//                }
//            } else {
//                System.out.println("Nessuna pubblicazione trovata con il titolo contenente: " + "mio");
//            }






            /////////////////////////////CERCA ED ELIMINA PER ISBN////////////////////////////////
//            EntityTransaction transaction = em.getTransaction();
//            transaction.begin();
//
//            Query query = em.createNamedQuery("Pubblicazione.removeByCodiceISBN");
//            query.setParameter("isbn", 7777888899L);
//
//            int removedCount = query.executeUpdate();
//
//            transaction.commit();
//
//            if (removedCount > 0) {
//                System.out.println("Pubblicazione con codice ISBN " + "7777888899L" + " rimossa con successo.");
//            } else {
//                System.out.println("Nessuna pubblicazione trovata con il codice ISBN " + "isbnDaRimuovere");
//            }



/////////////////////////CREAZIONE DUE UTENTI, TRE PUBBLICAZIONI E TRE PRESTITI ATTIVI/////////////////////////////
            UtenteDAO utenteDAO = new UtenteDAO(em);
            PubblicazioneDAO pubblicazioneDAO = new PubblicazioneDAO(em);
            PrestitoDAO prestitoDAO = new PrestitoDAO(em);

            Utente mario = new Utente("mario", "bianchi", new Date(), 1121233L);
           Utente giovanni = new Utente("giovanni", "rossi", new Date(), 2453453L);

            Pubblicazione libro4 = new Libro(112398950L, "Titolo Scaduto", 2020, 200, "Romanzo", "giovanni");
            Pubblicazione rivista4 = new Rivista(123092012L, "Titolo Attivo", 2022, 100, TipoPeriodicita.SETTIMANALE);
           Pubblicazione rivista5 = new Rivista(123031011L, "Ciaooooo", 2022, 500, TipoPeriodicita.MENSILE);

            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, -30);
            Date dataPrestito1 = cal.getTime();
            Date dataPrestito2 = new Date();
            Date dataPrestito3 = cal.getTime();

            Prestito prestito1 = new Prestito(mario, libro4, dataPrestito1);
            Prestito prestito2 = new Prestito(giovanni, rivista4, dataPrestito2);
            Prestito prestito3 = new Prestito(giovanni, rivista5, dataPrestito3);


//            utenteDAO.save(mario);
//            utenteDAO.save(giovanni);
//            pubblicazioneDAO.save(libro4);
//            pubblicazioneDAO.save(rivista4);
//            pubblicazioneDAO.save(rivista5);


//            prestitoDAO.save(prestito1);
//            prestitoDAO.save(prestito2);
//            prestitoDAO.save(prestito3);






            //////////////Named Query per trovare i prestiti attivi per l'utente specificato/////////////////////////////
            long numeroTessera = 2453453L;

            Query query = em.createNamedQuery("Prestito.findPrestitiAttiviByNumeroTessera");
            query.setParameter("numeroTessera", numeroTessera);

            List<Prestito> prestitiAttivi = query.getResultList();

            if (!prestitiAttivi.isEmpty()) {
                System.out.println("Prestiti attivi per l'utente con numero di tessera " + numeroTessera + ":");
                for (Prestito prestito : prestitiAttivi) {
                    System.out.println(prestito);
                }
            } else {
                System.out.println("Nessun prestito attivo trovato per l'utente con numero di tessera " + numeroTessera);
            }



















        } finally {
            em.close();
            JpaUtils.close();

        }
    }
}