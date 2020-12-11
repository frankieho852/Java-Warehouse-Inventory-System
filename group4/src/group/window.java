package group;
import javax.swing.*;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.*;
import net.coderazzi.filters.gui.AutoChoices;
import net.coderazzi.filters.gui.TableFilterHeader;
import net.coderazzi.filters.gui.TableFilterHeader.Position;

public class window extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
        new window();
    }
     
    public File xml = null;
    public Document dom = null; 
    public JScrollPane jScrollPane1;
    public DefaultTableModel model;
    public JTable tableShowRecord;
    private JMenuBar menuBar;
    private JMenu mnTheRecordNeed;
    private JMenu mnSaveFileAs;
    private JMenu mnSaveAsPdf;
    private JMenuItem mnNewMenu;
    private JMenuItem mnNewMenu_1;
    private JMenuItem mnNewMenu_2;
    private JMenuItem mntmOther;
    private Panel panel;
    private Button button;
    private Button button_1;
    private JCheckBoxMenuItem checkbox;
    private JCheckBoxMenuItem checkbox_1;
    private JCheckBoxMenuItem checkbox_2;
    private JCheckBoxMenuItem checkbox_3;
    private JCheckBoxMenuItem checkbox_4;
    private JCheckBoxMenuItem checkbox_5;
    private JCheckBoxMenuItem checkbox_6;
    private JCheckBoxMenuItem checkbox_7;
    private JCheckBoxMenuItem checkbox_8;
    private JCheckBoxMenuItem checkbox_9;
    private JCheckBoxMenuItem checkbox_10;
    private JCheckBoxMenuItem checkbox_11;
    private JCheckBoxMenuItem checkbox_12;
    private JCheckBoxMenuItem checkbox_13;
    private JCheckBoxMenuItem checkbox_14;
    private JCheckBoxMenuItem checkbox_15;
    private JCheckBoxMenuItem checkbox_16;
     
 // create basic window for GUI
    public window() {
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Inventory list");
        setSize(1000,600);
        xml = new File("AST10106_ProjectSampleData.xml");        
        installGUI();     
        setVisible(true);   
		//create all the item in the xml file
    }
     
	public void installGUI() {
		 data[]xmlRecords=new data[100];
		 try {
		 //read the xml file in the application and translate those 100 records to be a object and store them in a array

			//create a array to store those 100 record in the xml file
			 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			 DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			 Document doc = dBuilder.parse(xml);
		 
			 doc.getDocumentElement().normalize();
			 
			 NodeList nList = doc.getElementsByTagName("record");
		 
			 //translate those record to a object and store in the array records
			 for (int temp = 0; temp < nList.getLength(); temp++) {

				 Node nNode = nList.item(temp);

				 if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					 Element e = (Element) nNode;
					
					 String recordsIndex = e.getAttribute("index");
					 String id = e.getElementsByTagName("Id").item(0).getTextContent();
					 String name = e.getElementsByTagName("Name").item(0).getTextContent();
					 String category = e.getElementsByTagName("Category").item(0).getTextContent();
					 String subCategory = e.getElementsByTagName("SubCategory").item(0).getTextContent();
					 String brand = e.getElementsByTagName("Brand").item(0).getTextContent();
					 String supplier = e.getElementsByTagName("Supplier").item(0).getTextContent();
					 String minOrderQuantity = e.getElementsByTagName("MinOrderQuantity").item(0).getTextContent();
					 String targetBatchVolume = e.getElementsByTagName("TargetBatchVolume").item(0).getTextContent();
					 String volume = e.getElementsByTagName("Volume").item(0).getTextContent();
					 String sellPrice = e.getElementsByTagName("SellPrice").item(0).getTextContent();
					 String sellCurrency  =  e.getElementsByTagName("SellCurrency").item(0).getTextContent();
					 String buyPrice  =  e.getElementsByTagName("BuyPrice").item(0).getTextContent();
					 String buyCurrency = e.getElementsByTagName("BuyCurrency").item(0).getTextContent();
					 String stockOnHand = e.getElementsByTagName("StockOnHand").item(0).getTextContent();
					 String stockOnOrder = e.getElementsByTagName("StockOnOrder").item(0).getTextContent();
					 String leadTime = e.getElementsByTagName("LeadTime").item(0).getTextContent();

					 xmlRecords[temp]=new data(recordsIndex,id,name,category,subCategory,brand,supplier,minOrderQuantity
							 				,targetBatchVolume,volume,sellPrice,sellCurrency,buyPrice,buyCurrency,
							 				stockOnHand,stockOnOrder,leadTime);
				}

			}
		   } catch (Exception e) {
			e.printStackTrace();
		   }
		 
		//create a table within read those data and title
    	String[] columns ={
        	 "Records Index","Id","Name","Category","Sub Category","Brand","Supplier","Min Order Quantity","Target Batch Volume",
            		"Volume","Sell Price","Sell Currency","Buy Price","Buy Currency","Stock On Hand","Stock On Order","Lead Time" };
    	Object[][] rows=new Object[100][17];
        for (int i = 0; i < 100; i++) {
        	rows[i][0] = xmlRecords[i].getRecordsIndex();
        	rows[i][1] = xmlRecords[i].getId();
        	rows[i][2] = xmlRecords[i].getName();
        	rows[i][3] = xmlRecords[i].getCategory();
        	rows[i][4] = xmlRecords[i].getSubCategory();
        	rows[i][5] = xmlRecords[i].getBrand();
        	rows[i][6] = xmlRecords[i].getSupplier();
        	rows[i][7] = xmlRecords[i].getMinOrderQuantity();
        	rows[i][8] = xmlRecords[i].getTargetBatchVolume();
        	rows[i][9] = xmlRecords[i].getVolume();
        	rows[i][10] = xmlRecords[i].getSellPrice();
        	rows[i][11] = xmlRecords[i].getSellCurrency();
        	rows[i][12] = xmlRecords[i].getBuyPrice();
        	rows[i][13] = xmlRecords[i].getBuyCurrency();
        	rows[i][14] = xmlRecords[i].getStockOnHand();
        	rows[i][15] = xmlRecords[i].getStockOnOrder();
        	rows[i][16] = xmlRecords[i].getLeadTime();
        	}

        
        @SuppressWarnings("serial")
		TableModel model = new DefaultTableModel(rows, columns){
            @SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int column) {
                Class returnValue;
                if ((column >= 0) && (column < getColumnCount())) {
                  returnValue = getValueAt(0, column).getClass();
                } else {
                  returnValue = Object.class;
                }
                return returnValue;
              }
            };
            
    	//creates an instance of the table class and sets it up in a scrollpane
    	//set the sorter for upper and downer number and letter
        tableShowRecord = new JTable(model);
        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        tableShowRecord.setRowSorter(sorter);
        jScrollPane1 = new JScrollPane(tableShowRecord);
        getContentPane().setLayout(new BorderLayout(0, 0)); 
        Container ctr = getContentPane();
        ctr.add(jScrollPane1, BorderLayout.CENTER);
        
        //create filter for searching and select specific record details
        TableFilterHeader filterHeader = new TableFilterHeader(tableShowRecord, AutoChoices.ENABLED);
        filterHeader.setPosition(Position.TOP);

        //create the top-up menubar for user to select show selected record details and
        //choose the catogory for save the pdf file
        menuBar = new JMenuBar();
        getContentPane().add(menuBar, BorderLayout.NORTH);
        
        //This menu including checkboxs which is mean all record details for user to choose 
        //which record details to show with he/she likes
        mnTheRecordNeed = new JMenu("The columns Need to Show and will be Save");
        menuBar.add(mnTheRecordNeed);

        boolean[]checkBox=new boolean[17];
        for(int i=0;i<checkBox.length;i++)
        	checkBox[i]=true;

        checkbox = new JCheckBoxMenuItem("Record Index");
        checkbox.setEnabled(false);
        checkbox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		checkBox[0]=checkbox.getState();
        		showOrNot(checkBox,columns,rows,xmlRecords);
        	}
        });
        checkbox.setSelected(true);
        mnTheRecordNeed.add(checkbox);

        	
        checkbox_1 = new JCheckBoxMenuItem("Id");
        checkbox_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		checkBox[1]=checkbox_1.getState();
        		showOrNot(checkBox,columns,rows,xmlRecords);
        	}
        });
        checkbox_1.setSelected(true);
        mnTheRecordNeed.add(checkbox_1);
        
        checkbox_2 = new JCheckBoxMenuItem("Name");
        checkbox_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		checkBox[2]=checkbox_2.getState();
        		showOrNot(checkBox,columns,rows,xmlRecords);
        	}
        });
        checkbox_2.setSelected(true);
        mnTheRecordNeed.add(checkbox_2);
        
        checkbox_3 = new JCheckBoxMenuItem("Category");
        checkbox_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		checkBox[3]=checkbox_3.getState();
        		showOrNot(checkBox,columns,rows,xmlRecords);
        	}
        });
        checkbox_3.setSelected(true);
        mnTheRecordNeed.add(checkbox_3);
        
        checkbox_4 = new JCheckBoxMenuItem("Sub Category");
        checkbox_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		checkBox[4]=checkbox_4.getState();
        		showOrNot(checkBox,columns,rows,xmlRecords);
        	}
        });
        checkbox_4.setSelected(true);
        mnTheRecordNeed.add(checkbox_4);
        
        checkbox_5 = new JCheckBoxMenuItem("Brand");
        checkbox_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		checkBox[5]=checkbox_5.getState();
        		showOrNot(checkBox,columns,rows,xmlRecords);
        	}
        });
        checkbox_5.setSelected(true);
        mnTheRecordNeed.add(checkbox_5);
        
        checkbox_6 = new JCheckBoxMenuItem("Supplier");
        checkbox_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		checkBox[6]=checkbox_6.getState();
        		showOrNot(checkBox,columns,rows,xmlRecords);
        	}
        });
        checkbox_6.setSelected(true);
        mnTheRecordNeed.add(checkbox_6);
        
        checkbox_7 = new JCheckBoxMenuItem("Min Order Quantity");
        checkbox_7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		checkBox[7]=checkbox_7.getState();
        		showOrNot(checkBox,columns,rows,xmlRecords);
        	}
        });
        checkbox_7.setSelected(true);
        mnTheRecordNeed.add(checkbox_7);
        
        checkbox_8 = new JCheckBoxMenuItem("Target Batch Volume");
        checkbox_8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		checkBox[8]=checkbox_8.getState();
        		showOrNot(checkBox,columns,rows,xmlRecords);
        	}
        });
        checkbox_8.setSelected(true);
        mnTheRecordNeed.add(checkbox_8);
        
        checkbox_9 = new JCheckBoxMenuItem("Volume");
        checkbox_9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		checkBox[9]=checkbox_9.getState();
        		showOrNot(checkBox,columns,rows,xmlRecords);
        	}
        });
        checkbox_9.setSelected(true);
        mnTheRecordNeed.add(checkbox_9);
        
        checkbox_10 = new JCheckBoxMenuItem("Sell Currency");
        checkbox_10.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		checkBox[10]=checkbox_10.getState();
        		showOrNot(checkBox,columns,rows,xmlRecords);
        	}
        });
        checkbox_10.setSelected(true);
        mnTheRecordNeed.add(checkbox_10);
        
        checkbox_11 = new JCheckBoxMenuItem("Sell Price");
        checkbox_11.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		checkBox[11]=checkbox_11.getState();
        		showOrNot(checkBox,columns,rows,xmlRecords);
        	}
        });
        checkbox_11.setSelected(true);
        mnTheRecordNeed.add(checkbox_11);
        
        checkbox_12 = new JCheckBoxMenuItem("Buy Price");
        checkbox_12.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		checkBox[12]=checkbox_12.getState();
        		showOrNot(checkBox,columns,rows,xmlRecords);
        	}
        });
        checkbox_12.setSelected(true);
        mnTheRecordNeed.add(checkbox_12);
        
        checkbox_13 = new JCheckBoxMenuItem("Buy Currency");
        checkbox_13.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		checkBox[13]=checkbox_13.getState();
        		showOrNot(checkBox,columns,rows,xmlRecords);
        	}
        });
        checkbox_13.setSelected(true);
        mnTheRecordNeed.add(checkbox_13);
        
        checkbox_14 = new JCheckBoxMenuItem("Stock On Hand");
        checkbox_14.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		checkBox[14]=checkbox_14.getState();
        		showOrNot(checkBox,columns,rows,xmlRecords);
        	}
        });
        checkbox_14.setSelected(true);
        mnTheRecordNeed.add(checkbox_14);
        
        checkbox_15 = new JCheckBoxMenuItem("Stock On Order");
        checkbox_15.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		checkBox[15]=checkbox_15.getState();
        		showOrNot(checkBox,columns,rows,xmlRecords);
        	}
        });
        checkbox_15.setSelected(true);
        mnTheRecordNeed.add(checkbox_15);
        
        checkbox_16 = new JCheckBoxMenuItem("Lead Time");
        checkbox_16.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		checkBox[16]=checkbox_16.getState();
        		showOrNot(checkBox,columns,rows,xmlRecords);
        	}
        });
        checkbox_16.setSelected(true);
        mnTheRecordNeed.add(checkbox_16);
        
        //save Record
        mnSaveFileAs = new JMenu("Save file as");
        menuBar.add(mnSaveFileAs);
        
        //For user to save the records in a pdf file by a selected category
        mnSaveAsPdf = new JMenu("Save as PDF File");
        mnSaveFileAs.add(mnSaveAsPdf);
        
        mnNewMenu = new JMenuItem("Technology");
        mnNewMenu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int control=save(xmlRecords,checkBox);
        		if(control==0){	
        			showPdf("Technology",xmlRecords,checkbox_3.getState());
        		}else
        			return;
        	}
        });
        mnSaveAsPdf.add(mnNewMenu);

        
        mnNewMenu_1 = new JMenuItem("Office Supplies");
        mnNewMenu_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int control=save(xmlRecords,checkBox);
        		if(control==0){
        			showPdf("Office Supplies",xmlRecords,checkbox_3.getState());
        		}else
        			return;
        	}
        });
        mnSaveAsPdf.add(mnNewMenu_1);
        
        mnNewMenu_2 = new JMenuItem("Furniture");
        mnNewMenu_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int control=save(xmlRecords,checkBox);
        		if(control==0){
        			showPdf("Furniture",xmlRecords,checkbox_3.getState());
        		}else
        			return;
        	}
        });
        mnSaveAsPdf.add(mnNewMenu_2);
        
        //For users had modifry category which is new for save the pdf file
        mntmOther = new JMenuItem("Other");
        mntmOther.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		save(xmlRecords,checkBox);
        		userInput jf = new userInput(xmlRecords,checkbox_3.getState());
				jf.setVisible(true);
        	}
        });
        mnSaveAsPdf.add(mntmOther);
        
        panel = new Panel();
        getContentPane().add(panel, BorderLayout.SOUTH);
        
        //Create all the item in the xml file
        button = new Button("Save the date show in table");
        button.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int control=save(xmlRecords,checkBox);
        		if(control==0){	
        			try {
					
        				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        				// root elements
        				Document doc = docBuilder.newDocument();
        				Element rootElement = doc.createElement("data");
        				doc.appendChild(rootElement);
					
        				for(int i = 0; i < xmlRecords.length; i++){
					
        					// staff elements
        					Element records = doc.createElement("records");
        					rootElement.appendChild(records);
					
        					// staff elements
        					Element record = doc.createElement("record");
        					rootElement.appendChild(record);
						
        					// set attribute to staff element
        					Attr attr = doc.createAttribute("index");
        					attr.setValue(""+(i+1));
        					record.setAttributeNode(attr);
					
        					// shorten way
        					// staff.setAttribute("id", "1");
        					
        					// Brand elements
        					Element Brand = doc.createElement("Brand");
        					Brand.appendChild(doc.createTextNode(xmlRecords[i].getBrand()));
        					record.appendChild(Brand);
					
        					// BuyCurrency elements
        					Element BuyCurrency = doc.createElement("BuyCurrency");
							BuyCurrency.appendChild(doc.createTextNode(xmlRecords[i].getBuyCurrency()));
							record.appendChild(BuyCurrency);
					
							// BuyPrice elements
							Element BuyPrice = doc.createElement("BuyPrice");
							BuyPrice.appendChild(doc.createTextNode(Double.toString(xmlRecords[i].getBuyPrice())));
							record.appendChild(BuyPrice);
					
							// Category elements
							Element Category = doc.createElement("Category");
							Category.appendChild(doc.createTextNode(xmlRecords[i].getCategory()));
							record.appendChild(Category);
					
							// Id elements
							Element Id = doc.createElement("Id");
							Id.appendChild(doc.createTextNode(Integer.toString(xmlRecords[i].getId())));
							record.appendChild(Id);
					
							// LeadTime elements
							Element LeadTime = doc.createElement("LeadTime");
							LeadTime.appendChild(doc.createTextNode(Integer.toString(xmlRecords[i].getLeadTime())));
							record.appendChild(LeadTime);
					
							// MinOrderQuantity elements
							Element MinOrderQuantity = doc.createElement("MinOrderQuantity");
							MinOrderQuantity.appendChild(doc.createTextNode(Double.toString(xmlRecords[i].getMinOrderQuantity())));
							record.appendChild(MinOrderQuantity);
					
							//Name elements
							Element Name = doc.createElement("Name");
							Name.appendChild(doc.createTextNode(xmlRecords[i].getName()));
							record.appendChild(Name);
					
							// SellCurrency elements
							Element SellCurrency = doc.createElement("SellCurrency");
							SellCurrency.appendChild(doc.createTextNode(xmlRecords[i].getSellCurrency()));
							record.appendChild(SellCurrency);
					
							// SellPrice elements
							Element SellPrice = doc.createElement("SellPrice");
							SellPrice.appendChild(doc.createTextNode(Double.toString(xmlRecords[i].getSellPrice())));
							record.appendChild(SellPrice);
					
							// StockOnHand elements
							Element StockOnHand = doc.createElement("StockOnHand");
							StockOnHand.appendChild(doc.createTextNode(Integer.toString(xmlRecords[i].getStockOnHand())));
							record.appendChild(StockOnHand);
					
							// StockOnOrder elements
							Element StockOnOrder = doc.createElement("StockOnOrder");
							StockOnOrder.appendChild(doc.createTextNode(Integer.toString(xmlRecords[i].getStockOnOrder())));
							record.appendChild(StockOnOrder);
					
							// SubCategory elements
							Element SubCategory = doc.createElement("SubCategory");
							SubCategory.appendChild(doc.createTextNode(xmlRecords[i].getSubCategory()));
							record.appendChild(SubCategory);
					
							// Supplier elements
							Element Supplier = doc.createElement("Supplier");
							Supplier.appendChild(doc.createTextNode(xmlRecords[i].getSupplier()));
							record.appendChild(Supplier);
					
							// TargetBatchVolume elements
							Element TargetBatchVolume = doc.createElement("TargetBatchVolume");
							TargetBatchVolume.appendChild(doc.createTextNode(Double.toString(xmlRecords[i].getTargetBatchVolume())));
							record.appendChild(TargetBatchVolume);

							// Volume elements
							Element Volume = doc.createElement("Volume");
							Volume.appendChild(doc.createTextNode(Double.toString(xmlRecords[i].getVolume())));
							record.appendChild(Volume);
        				}
        			
					Date d1 = new Date();
					DateFormat formatter = new SimpleDateFormat("ddMMyy");

					   String date2 =formatter.format(d1);
					
					// write the content into xml file
							TransformerFactory transformerFactory = TransformerFactory.newInstance();
							Transformer transformer = transformerFactory.newTransformer();
							DOMSource source = new DOMSource(doc);
							StreamResult result = new StreamResult(new File("inventory_"+date2+".xml"));

							// Output to console for testing
							// StreamResult result = new StreamResult(System.out);

							transformer.transform(source, result);
        			
        				}catch (ParserConfigurationException pce) {
							pce.printStackTrace();
						  } catch (TransformerException tfe) {
							tfe.printStackTrace();
						  }
        		}else
        			return;
        	}
        });
        panel.add(button);
        
        // Exit the program
        button_1 = new Button("Finish");
        button_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		System.exit(0);
        	}
        });
        panel.add(button_1);
    }
	
	//The method to do the save function 
	public int save(data[]xmlRecords,boolean[]checkBox){
		String recordsIndex;
		String []recordsIndexs=new String[100];
		for(int i=0;i<recordsIndexs.length;i++)
			recordsIndexs[i]="";
		
		for(int i=0;i<tableShowRecord.getRowCount();i++){ 
			//to check the is the record index correct
			recordsIndex=tableShowRecord.getValueAt(i, 0).toString();
			if(Integer.parseInt(recordsIndex)>100||Integer.parseInt(recordsIndex)<1){
				indexError jf = new indexError();
				jf.setVisible(true);
				//if it is worng,return 1 
				return 1;
			}
			
			//to check is the record index repeat
			int y=numsCompare(recordsIndexs,recordsIndex);
			if(y==1){
				indexError jf = new indexError();
				jf.setVisible(true);
				//if it is repeat ,return 1
				return 1;
				}
			//update the array in this method ,use to check the next record index is repeat or not
			recordsIndexs[i]=recordsIndex;
		}
		int y=0;
		for (int i = 0; i<checkBox.length; i++){
			if(checkBox[i]==true){
				y++;
			}
		}
		int z=0;
		//update those 100 objects by the date show at the table
		for(int i=0;i<tableShowRecord.getRowCount();i++){ 
			recordsIndex=tableShowRecord.getValueAt(i, 0).toString();
			int x = Integer.parseInt(recordsIndex);
			if(checkBox[0]==true){
				z%=y;
				xmlRecords[x-1].setRecordsIndex(tableShowRecord.getValueAt(i, z).toString());
				z++;}
			if(checkBox[1]==true){
				z%=y;
				xmlRecords[x-1].setId(tableShowRecord.getValueAt(i, z).toString());
				z++;}
			if(checkBox[2]==true){
				z%=y;
				xmlRecords[x-1].setName(tableShowRecord.getValueAt(i, z).toString());
				z++;}
			if(checkBox[3]==true){
				z%=y;
				xmlRecords[x-1].setCategory(tableShowRecord.getValueAt(i, z).toString());
				z++;}
			if(checkBox[4]==true){
				z%=y;
				xmlRecords[x-1].setSubCategory(tableShowRecord.getValueAt(i, z).toString());
				z++;}
			if(checkBox[5]==true){
				z%=y;
				xmlRecords[x-1].setBrand(tableShowRecord.getValueAt(i, z).toString());
				z++;}
			if(checkBox[6]==true){
				z%=y;
				xmlRecords[x-1].setSupplier(tableShowRecord.getValueAt(i, z).toString());
				z++;}
			if(checkBox[7]==true){
				z%=y;
				xmlRecords[x-1].setMinOrderQuantity(tableShowRecord.getValueAt(i, z).toString());
				z++;}
			if(checkBox[8]==true){
				z%=y;
				xmlRecords[x-1].setTargetBatchVolume(tableShowRecord.getValueAt(i, z).toString());
				z++;}
			if(checkBox[9]==true){
				z%=y;
				xmlRecords[x-1].setVolume(tableShowRecord.getValueAt(i, z).toString());
				z++;}
			if(checkBox[10]==true){
				z%=y;
				xmlRecords[x-1].setSellPrice(tableShowRecord.getValueAt(i, z).toString());
				z++;}
			if(checkBox[11]==true){
				z%=y;
				xmlRecords[x-1].setSellCurrency(tableShowRecord.getValueAt(i, z).toString());
				z++;}
			if(checkBox[12]==true){
				z%=y;
				xmlRecords[x-1].setBuyPrice(tableShowRecord.getValueAt(i, z).toString());
				z++;}
			if(checkBox[13]==true){
				z%=y;
				xmlRecords[x-1].setBuyCurrency(tableShowRecord.getValueAt(i, z).toString());
				z++;}
			if(checkBox[14]==true){
				z%=y;
				xmlRecords[x-1].setStockOnHand(tableShowRecord.getValueAt(i, z).toString());
				z++;}
			if(checkBox[15]==true){
				z%=y;
				xmlRecords[x-1].setStockOnOrder(tableShowRecord.getValueAt(i, z).toString());
				z++;}
			if(checkBox[16]==true){
				z%=y;
				xmlRecords[x-1].setLeadTime(tableShowRecord.getValueAt(i, z).toString());
				z++;}
		}
		//if there is on any mistaken ,it will return 0 to tall the apps it save successfully
		return 0;
	}
	
	//method for create the pdf file
    public void showPdf(String Category,data[]xmlRecords,boolean checkBoxCategory){
    	//since this method need the most update category ,so the category should be show on the table 
    	//to update those objects' category
    	if(checkBoxCategory==false){
    		categoryError jf = new categoryError();
			jf.setVisible(true);
    	}
    	//to create the pdf file
    	com.itextpdf.text.Document document = new com.itextpdf.text.Document();
	      try
	      {
      		 PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Inventory.pdf"));
      		 document.open();
      		 for(int i=0;i<xmlRecords.length;i++){
      			 	if(Category.equals(xmlRecords[i].getCategory())){
      			 			document.add(new Paragraph("Records Index : " + xmlRecords[i].getRecordsIndex()));
      			 			document.add(new Paragraph("Id : " + xmlRecords[i].getId()));
      			 			document.add(new Paragraph("Name : " + xmlRecords[i].getName()));
      			 			document.add(new Paragraph("Category : " + xmlRecords[i].getCategory()));
      			 			document.add(new Paragraph("Sub Category : " + xmlRecords[i].getSubCategory()));
      			 			document.add(new Paragraph("Brand : " + xmlRecords[i].getBrand()));
      			 			document.add(new Paragraph("Supplier : " + xmlRecords[i].getSupplier()));
      			 			document.add(new Paragraph("Min Order Quantity : " + xmlRecords[i].getMinOrderQuantity()));
      			 			document.add(new Paragraph("Target Volume : " + xmlRecords[i].getVolume()));
      			 			document.add(new Paragraph("Volume : " + xmlRecords[i].getVolume()));
      			 			document.add(new Paragraph("Sell Currency : " + xmlRecords[i].getSellCurrency()));
      			 			document.add(new Paragraph("Sell Price : " + xmlRecords[i].getSellPrice()));
      			 			document.add(new Paragraph("Buy Currency : " + xmlRecords[i].getBuyCurrency()));
      			 			document.add(new Paragraph("Buy Price : " + xmlRecords[i].getBuyPrice()));
      			 			document.add(new Paragraph("Lead Time : "+xmlRecords[i].getLeadTime()));
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
    
    //method use to find is the number repeat in the array 
    public int numsCompare(String[]nums,String num){
		int x=0;
    	for(int i=0;i<nums.length;i++){
    		if(nums[i].equals(num)){
    			x++;
    		}
    	}
    	return x;
    }
    
    //the method to control will the item show on the table
    public void showOrNot(boolean[]a,String[]columns,Object[][]rows,data[]xmlRecords){
		int x=0;
		//to get how many item need to show
    	for(int i=0;i<a.length;i++){
    		if(a[i]==true){
    			x++;
    		}
    	}
    	
    	//to create the new columns and new row for the table
    	String[]nColumns=new String[x];
    	Object[][]nRows=new Object[100][x];
    	int z=0;
    	for(int i=0;i<a.length;i++){
    		if(a[i]==true){
    			nColumns[z]=columns[i];
    	        if(i==0)
    	        	for (int y = 0; y < xmlRecords.length; y++)
    	        		nRows[y][z] = xmlRecords[y].getRecordsIndex();
    	        else  if(i==1)
    	        	for (int y = 0; y < xmlRecords.length; y++)
    	        		nRows[y][z] = xmlRecords[y].getId();
    	        if(i==2)
    	        	for (int y = 0; y < xmlRecords.length; y++)
    	        		nRows[y][z] = xmlRecords[y].getName();
    	       	if(i==3)
    	        	for (int y = 0; y < xmlRecords.length; y++)
    	        		nRows[y][z] = xmlRecords[y].getCategory();
    	       	if(i==4)
    	        	for (int y = 0; y < xmlRecords.length; y++)
    	        		nRows[y][z] = xmlRecords[y].getSubCategory();
    	       	if(i==5)
    	        	for (int y = 0; y < xmlRecords.length; y++)
    	        		nRows[y][z] = xmlRecords[y].getBrand();
    	       	if(i==6)
    	        	for (int y = 0; y < xmlRecords.length; y++)
    	        		nRows[y][z] = xmlRecords[y].getSupplier();
    	       	if(i==7)
    	        	for (int y = 0; y < xmlRecords.length; y++)
    	        		nRows[y][z] = xmlRecords[y].getMinOrderQuantity();
    	       	if(i==8)
    	        	for (int y = 0; y < xmlRecords.length; y++)
    	        		nRows[y][z] = xmlRecords[y].getTargetBatchVolume();
    	       	if(i==9)
    	        	for (int y = 0; y < xmlRecords.length; y++)
    	        		nRows[y][z] = xmlRecords[y].getVolume();
    	       	if(i==10)
    	        	for (int y = 0; y < xmlRecords.length; y++)
    	        		nRows[y][z] = xmlRecords[y].getSellPrice();
            	if(i==11)
    	        	for (int y = 0; y < xmlRecords.length; y++)
    	        		nRows[y][z] = xmlRecords[y].getSellCurrency();
    	        if(i==12)
    	        	for (int y = 0; y < xmlRecords.length; y++)
    	        		nRows[y][z] = xmlRecords[y].getBuyPrice();
   	        	if(i==13)
    	        	for (int y = 0; y < xmlRecords.length; y++)
    	        		nRows[y][z] = xmlRecords[y].getBuyCurrency();
   	        	if(i==14)
    	        	for (int y = 0; y < xmlRecords.length; y++)
    	        		nRows[y][z] = xmlRecords[y].getStockOnHand();
    	        if(i==15)
    	        	for (int y = 0; y < xmlRecords.length; y++)
    	        		nRows[y][z] = xmlRecords[y].getStockOnOrder();
    	        if(i==16)
    	        	for (int y = 0; y < xmlRecords.length; y++)
    	        		nRows[y][z] = xmlRecords[y].getLeadTime();
    	        z++;
    	        }
    	}
    	//refresh the table
    	DefaultTableModel newModel = new DefaultTableModel(nRows, nColumns);
    	tableShowRecord.setModel(newModel);
    }
}
    

