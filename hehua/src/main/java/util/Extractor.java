package util;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 *
 * @since 2013-10-13
 * @author lwh
 */

public class Extractor {
	
	
		public static void main(String[] args) {
//			String pathname = "E://test.doc";
			String pathname = "E://u.doc";
			String htmlfile = "E://u.mht";
			
			String lp = System.getProperty("java.library.path");
			System.out.println("---> " + lp.indexOf("jacob"));
			try {
				//POITextExtractor extractor = ExtractorFactory.createExtractor(new File(pathname));
				
				//String text = new org.textmining.text.extraction.WordExtractor().extractText(new FileInputStream(pathname));
				
				//String content = extractor.getText();
				
//				org.apache.poi.xwpf.extractor.XWPFWordExtractor docx = new XWPFWordExtractor(XWPFDocument.openPackage(pathname)); 
//				//提取.docx正文文本 
//				String text2 = docx.getText();
//				System.out.println(text2);
				
//				OPCPackage oPCPackage = POIXMLDocument.openPackage(pathname);
//	            XWPFDocument xwpf = new XWPFDocument(oPCPackage);
//	            POIXMLTextExtractor ex = new XWPFWordExtractor(xwpf);
//	            System.out.print(ex.getText());
//	            oPCPackage.close();
				
//				HSSFWorkbook wookbook = new HSSFWorkbook(new FileInputStream(  
//	                    pathname)); 
//				System.out.println(new String(wookbook.getBytes()));
//				
				wordToHtml(pathname, htmlfile);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// 8 代表word保存成html  
	    public static final int WORD_HTML = 8;   
		
		/**   
	     * WORD转HTML   
	     * @param docfile WORD文件全路径   
	     * @param htmlfile 转换后HTML存放路径   
	     */    
	    public static void wordToHtml(String docfile, String htmlfile)     
	    {     
	        // 启动word应用程序(Microsoft Office Word 2003)  
	        ActiveXComponent app = new ActiveXComponent("Word.Application");  
	        System.out.println("*****正在转换...*****");  
	        try    
	        {     
	            // 设置word应用程序不可见    
	            app.setProperty("Visible", new Variant(false));    
	            // documents表示word程序的所有文档窗口，（word是多文档应用程序）  
	            Dispatch docs = app.getProperty("Documents").toDispatch();    
	            // 打开要转换的word文件  
	            Dispatch doc = Dispatch.invoke(     
	                    docs,     
	                    "Open",     
	                    Dispatch.Method,     
	                    new Object[] { docfile, new Variant(false),   
	                            new Variant(true) }, new int[1]).toDispatch();     
	            // 作为html格式保存到临时文件  
	            Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] {     
	                    htmlfile, new Variant(WORD_HTML) }, new int[1]);     
	            // 关闭word文件  
	            Dispatch.call(doc, "Close", new Variant(false));     
	        }     
	        catch (Exception e)     
	        {     
	            e.printStackTrace();     
	        }     
	        finally    
	        {     
	            //关闭word应用程序  
	            app.invoke("Quit", new Variant[] {});     
	        }   
	        System.out.println("*****转换完毕********");  
	    }  

}
