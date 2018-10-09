import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;

/* CLASS THAT HANDLES AMAZON S3 OBJECTS */
public class AmazonS3Object {

	public AmazonS3Object() {
	}
	
	/* WRITE TO LOCAL TEXT FILE, THEN UPLOAD FILE TO AMAZON S3 SERVICES */
	public void writeToFile(String FILENAME, String input) throws IOException{
		Files.write(Paths.get(FILENAME), input.getBytes(), StandardOpenOption.APPEND);
		uploadtoAmazonS3Bucket();
	}
	  
	/* UPLOAD CONTENTS OF LOCAL TEXT FILE TO AMAZON S3 */
	public void uploadtoAmazonS3Bucket(){

		//create Amazon S3 Object		
		AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).build();  

		// get bucket & its object (the game_replay.txt file)
		ObjectListing objectListing = s3.listObjects("riskgamebucket");
		List<S3ObjectSummary> os = objectListing.getObjectSummaries();

		// Upload a file as a new object with ContentType and title specified.
		PutObjectRequest request = new PutObjectRequest("riskgamebucket", os.get(0).getKey(), new File("game_replay.txt"));
		s3.putObject(request);

	}
	
	// clear contents of local text file at beginning of game
	public void clearFileContents() throws FileNotFoundException{
		PrintWriter pw = null;
		pw = new PrintWriter("game_replay.txt");
		pw.close();
		PrintWriter pwTest = null;
		pwTest = new PrintWriter("test.txt");
		pwTest.close();
	}
}
