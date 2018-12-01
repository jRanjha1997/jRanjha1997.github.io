package Assignment3.word;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.bg.PixelBoundryBackground;
import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.font.scale.LinearFontScalar;
import java.awt.*;
import java.io.*;
import org.apache.log4j.BasicConfigurator;

public class App 
{
    public static void main( String[] args )  throws FileNotFoundException, java.io.IOException
    {
    	BasicConfigurator.configure();
    	final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(300);
        frequencyAnalyzer.setMinWordLength(1);


        final java.util.List<WordFrequency> wordFrequencies = frequencyAnalyzer.load("C:\\Users\\Jahan\\eclipse-workspace\\word\\src\\main\\java\\Assignment3\\word\\output.txt");

        final Dimension dimension = new Dimension(700, 1000);
        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new PixelBoundryBackground("C:\\Users\\Jahan\\eclipse-workspace\\word\\src\\main\\java\\Assignment3\\word\\background.jpg"));
        wordCloud.setBackgroundColor(new Color(0x0000F0FF, true));
        wordCloud.setFontScalar(new LinearFontScalar(35, 40));

        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("rectangle1.png");
    }
}
