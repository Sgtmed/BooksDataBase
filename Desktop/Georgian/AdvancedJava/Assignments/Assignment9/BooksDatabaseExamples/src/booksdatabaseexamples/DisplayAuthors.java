package booksdatabaseexamples;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * a) Select all authors from the authors table.
 * @author Sgtmed
 */
public class DisplayAuthors 
{

    /**
     *
     */
    public static void PrintAuthors()
   {
      // create an EntityManagerFactory for the persistence unit
      EntityManagerFactory entityManagerFactory = 
         Persistence.createEntityManagerFactory(
            "BooksDatabaseExamplesPU");

      // create an EntityManager for interacting with the persistence unit
      EntityManager entityManager = 
         entityManagerFactory.createEntityManager();

      // create a dynamic TypedQuery<Authors> that selects all authors
      TypedQuery<Authors> findAllAuthors = entityManager.createQuery(
         "SELECT author FROM Authors AS author", Authors.class);
      
      // display List of Authors
      System.out.printf("Authors Table of Books Database:%n%n");
      System.out.printf("%-12s%-13s%s%n", 
         "Author ID", "First Name", "Last Name");
      
      // get all authors, create a stream and display each author
      findAllAuthors.getResultList().stream()
         .forEach((author) -> 
            {
               System.out.printf("%-12d%-13s%s%n", author.getAuthorid(), 
                  author.getFirstname(), author.getLastname());
            }
         );
   }
}
