package lucene;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/12/5.
 */
public class TestLucene {
    @Test
    public void Test1() throws IOException {
        String path = "F:/lucene/index";
        Directory directory = FSDirectory.open(new File(path));
        StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_44);
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_44, analyzer);
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        Document doc = new Document();
        TextField textField = new TextField("title", "张虎涛", Field.Store.YES);
        doc.add(textField);
        indexWriter.addDocument(doc);
        indexWriter.close();
    }

}
