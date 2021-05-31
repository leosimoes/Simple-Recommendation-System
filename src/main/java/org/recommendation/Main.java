package org.recommendation;

import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.common.TasteException;

import java.io.IOException;
import java.util.List;

public class Main
{
    public static void main( String[] args )
    {
        final String FILE_NAME = "data.csv";
        final String PATHFILE = "src/main/resources/" + FILE_NAME;
        final long USER_ID = 1;
        final int NUM_RECOMMENDATIONS  = 5;

        try {
            DataModel products = DataModelLoader.ModelFromFile(PATHFILE);

            Recommender recommender = new SystemRecommenderBuilder().buildRecommender(products);

            System.out.println(NUM_RECOMMENDATIONS + " recommendations for user " + USER_ID + ":");
            List<RecommendedItem> recommendations = recommender.recommend(USER_ID, NUM_RECOMMENDATIONS);
            for (RecommendedItem recommendation : recommendations) {
                System.out.println("ItemID: " + recommendation.getItemID() + " | Recomendation value: " +recommendation.getValue());
            }

        } catch(IOException io){
            System.out.println( "IOException" );
            io.printStackTrace();
        } catch(TasteException te){
            System.out.println( "Taste Exception" );
            te.printStackTrace();
        } catch(Exception e){
            System.out.println( "Exception" );
            e.printStackTrace();
        }
    }
}
