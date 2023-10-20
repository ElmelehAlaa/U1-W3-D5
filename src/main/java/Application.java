import com.github.javafaker.Faker;
import dao.GenericDAO;
import org.apache.commons.io.FileUtils;
import utils.JpaUtils;

import javax.persistence.EntityManager;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Supplier;

public class Application {

    public static void main(String[] args) {

        EntityManager em= JpaUtils.getEmf().createEntityManager();

    }
}
