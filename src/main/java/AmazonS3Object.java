import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.Serializable;
import java.nio.file.StandardOpenOption;
import java.util.List;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;

/**
 * Handles the Amazon S3 service. Takes care of writing to file, uploading, etc.
 */
public class AmazonS3Object implements Serializable{

	public AmazonS3Object() {
	}

	/**
	 * Writes input to a file and then uploads that file to Amazon S3
	 * @param FILENAME	The name of the file to be written to.
	 * @param input	The string of input to be written to the file.
	 * @throws IOException	exception
	 */
	public void writeToFile(String FILENAME, String input) throws IOException{
		Files.write(Paths.get(FILENAME), input.getBytes(), StandardOpenOption.APPEND);
		//uploadtoAmazonS3Bucket();
	}
	  
	/**
	 *  Uploads the content of the file to Amazon S3 service
	 */
// 	public void uploadtoAmazonS3Bucket(){

// 		//create Amazon S3 Object		
// 		AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).build();  

// 		// get bucket & its object (the game_replay.txt file)
// 		ObjectListing objectListing = s3.listObjects("riskgamebucket");
// 		List<S3ObjectSummary> os = objectListing.getObjectSummaries();

// 		// Upload a file as a new object with ContentType and title specified.
// 		PutObjectRequest request = new PutObjectRequest("riskgamebucket", os.get(0).getKey(), new File("game_replay.txt"));
// 		s3.putObject(request);

// 	}

	/**
	 * Clears contents of local text file at beginning of game.
	 * @throws FileNotFoundException	exception
	 */
	public void clearFileContents() throws FileNotFoundException{
		PrintWriter pw = null;
		pw = new PrintWriter("game_replay.txt");
		pw.close();
		PrintWriter pwTest = null;
		pwTest = new PrintWriter("test.txt");
		pwTest.close();
	}
}
