package group;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class userInput extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	@SuppressWarnings("unused")
	private static data[]xmlRecords;
	private static boolean checkBoxCategory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//userInput frame = new usernput1();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	// This for user want to modify a new catogry which is save a new pdf file
	@SuppressWarnings("static-access")
	public userInput(data[]xmlRecords,boolean checkBoxCategory) {
		this.checkBoxCategory=checkBoxCategory;
		this.xmlRecords=xmlRecords;
		setBounds(100, 100, 450, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// To get user's input and match their input is or not match the modify record in the table
		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setBounds(54, 38, 95, 75);
		contentPane.add(lblCategory);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(143, 65, 229, 21);
		contentPane.add(textField);
		
		// For system to search a modify record and user's input is or not right
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String category=textField.getText();
					int x = 0;
					System.out.println(xmlRecords[0].getCategory());
					System.out.println(category);
					for(int i=0;i<xmlRecords.length;i++){
						if(category.equals(xmlRecords[i].getCategory())){
							showPdf(category,xmlRecords);
							x++;
						}
					}
					if(x==0){
						UsersError jf = new UsersError();
						jf.setVisible(true);
					}
			}
		});
		btnFind.setBounds(165, 134, 87, 23);
		contentPane.add(btnFind);
	}
	
	//method to print out the pdf file
    public void showPdf(String Category,data[]xmlRecords){
    	if(checkBoxCategory==false){
    		categoryError jf = new categoryError();
			jf.setVisible(true);
    	}
    	com.itextpdf.text.Document document = new com.itextpdf.text.Document();
	      try
	      {
      		 PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Inventory.pdf"));
      		 document.open();
      		 for(int i=0;i<xmlRecords.length;i++){
      			 	if(Category.equals(xmlRecords[i].getCategory())){
      			 		document.add(new Paragraph("recordsIndex : "+xmlRecords[i].getRecordsIndex()));
      			 		document.add(new Paragraph("id : "+xmlRecords[i].getId()));
      			 		document.add(new Paragraph("name : "+xmlRecords[i].getName()));
      			 		document.add(new Paragraph("category : "+xmlRecords[i].getCategory()));
      			 		document.add(new Paragraph("subCategory : "+xmlRecords[i].getSubCategory()));
      			 		document.add(new Paragraph("brand : "+xmlRecords[i].getBrand()));
      			 		document.add(new Paragraph("supplier : "+xmlRecords[i].getSupplier()));
      			 		document.add(new Paragraph("minOrderQuantity : " +xmlRecords[i].getMinOrderQuantity()));
      			 		document.add(new Paragraph("volume : "+xmlRecords[i].getVolume()));
      			 		document.add(new Paragraph("sellCurrency : "+xmlRecords[i].getSellCurrency()));
      			 		document.add(new Paragraph("sellPrice : "+xmlRecords[i].getSellPrice()));
      			 		document.add(new Paragraph("buyCurrency : "+xmlRecords[i].getBuyCurrency()));
      			 		document.add(new Paragraph("buyPrice : "+xmlRecords[i].getBuyPrice()));
      			 		document.add(new Paragraph("stockOnHand : "+xmlRecords[i].getStockOnHand()));
      			 		document.add(new Paragraph("stockOnOrder : "+xmlRecords[i].getStockOnOrder()));						
  			 			document.add(new Paragraph("--------------------------------------"));
  			 			document.add(new Paragraph("Quanlity (Stock On Hand/Stock On Order): " + xmlRecords[i].getStockOnHand()
  			 					+ xmlRecords[i].getStockOnOrder() + "(" + xmlRecords[i].getStockOnHand() + "/" +
  			 					xmlRecords[i].getStockOnOrder() + ")" ));
  			 			document.add(new Paragraph("Units Price : " + xmlRecords[i].getSellPrice()));
  			 			document.add(new Paragraph(" "));
      			 	}
      		 	}
      		 	document.close();
      		 	writer.close();
	      		} catch (DocumentException e1)
	      		{
	      			e1.printStackTrace();
	      		} catch (FileNotFoundException e1)
	      		{
	      			e1.printStackTrace();
	      		}
    }
}
