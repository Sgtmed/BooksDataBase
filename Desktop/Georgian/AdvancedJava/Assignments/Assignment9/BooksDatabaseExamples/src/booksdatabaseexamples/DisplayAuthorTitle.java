/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksdatabaseexamples;

import java.util.Comparator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * b) Select a specific author and list all books for that author. 
 * Include each book’s title, year and ISBN. 
 * Order the information alphabetically by the author’s last then first name.
 * @author Sgtmed
 */
public class DisplayAuthorTitle 
{
   public static void PrintAuthorTitle()
   {
      // create an EntityManagerFactory for the persistence unit
      EntityManagerFactory entityManagerFactory = 
         Persistence.createEntityManagerFactory(
            "BooksDatabaseExamplesPU");

      // create an EntityManager for interacting with the persistence unit
      EntityManager entityManager = 
         entityManagerFactory.createEntityManager();

      // TypedQuery that returns all authors
      TypedQuery<Authors> findAllAuthors = 
         entityManager.createNamedQuery("Authors.findAll", Authors.class);
      
      // display titles grouped by author
      System.out.printf("Titles grouped by author:%n");

      // get the List of Authors then display the results
      findAllAuthors.getResultList().stream()
         .sorted(Comparator.comparing(Authors::getLastname)
            .thenComparing(Authors::getFirstname))
         .forEach((author) ->
            {
               System.out.printf("%n%s %s:%n", 
                  author.getFirstname(), author.getLastname());          

               for (Titles title : author.getTitlesList())
               {
                  System.out.printf("\t%s%n", title.getTitle()); 
               }
            }
         );

      // TypedQuery that returns all titles
      TypedQuery<Titles> findAllTitles = 
         entityManager.createNamedQuery("Titles.findAll", Titles.class);
   }
}
