package group;

public class data {
	
	// To store information about a record
	// Instance variables
	private int recordsIndex;
	private int id;
	private String name;
	private String category;
	private String subCategory;
	private String brand;
	private String supplier;
	private double minOrderQuantity;
	private double targetBatchVolume;
	private double volume;
	private double sellPrice ;
	private String sellCurrency;
	private double buyPrice;
	private String buyCurrency;
	private int stockOnHand;
	private int stockOnOrder;
	private int leadTime;
	
	// Other constructor
	public data (String recordsIndex,String id,String name,String category,String subCategory,String brand,
			String supplier,String minOrderQuantity,String targetBatchVolume,String volume,String sellPrice,
			String sellCurrency,String buyPrice,String buyCurrency,String stockOnHand,String stockOnOrder,String leadTime){
		this.recordsIndex=Integer.parseInt(recordsIndex);
		this.id=Integer.parseInt(id);
		this.name=name;
		this.category=category;
		this.subCategory=subCategory;
		this.brand=brand;
		this.supplier=supplier;
		this.minOrderQuantity=Double.parseDouble(minOrderQuantity);
		this.targetBatchVolume=Double.parseDouble(targetBatchVolume);
		this.volume=Double.parseDouble(volume);
		this.sellPrice=Double.parseDouble(sellPrice);
		this.sellCurrency=sellCurrency;
		this.buyPrice=Double.parseDouble(buyPrice);
		this.buyCurrency=buyCurrency;
		this.stockOnHand=Integer.parseInt(stockOnHand);
		this.stockOnOrder=Integer.parseInt(stockOnOrder);
		this.leadTime=Integer.parseInt(leadTime);
	}
	
	// those set method
	public void setRecordsIndex(String recordsIndex){
		this.recordsIndex = Integer.parseInt(recordsIndex);
	}
	public void setId(String id){
		this.id = Integer.parseInt(id);
	}
	public void setName(String name){
		this.name = name;
	}
	public void setCategory(String category){
		this.category = category;
	}
	
	public void setSubCategory(String subCategory){
		this.subCategory = subCategory;
	}
	public void setBrand(String brand){
		this.brand = brand;
	}
	public void setSupplier(String supplier){
		this.supplier = supplier;
	}
	public void setMinOrderQuantity(String minOrderQuantity){
		this.minOrderQuantity = Double.parseDouble(minOrderQuantity);
	}
	public void setTargetBatchVolume(String targetBatchVolume){
		this.targetBatchVolume = Double.parseDouble(targetBatchVolume);
	}
	public void setVolume(String volume){
		this.volume = Double.parseDouble(volume);
	}
	public void setSellPrice(String sellPrice){
		this.sellPrice = Double.parseDouble(sellPrice);
	}	
	public void setSellCurrency(String sellCurrency){
		this.sellCurrency = sellCurrency;
	}
	public void setBuyPrice(String buyPrice){
		this.buyPrice = Double.parseDouble(buyPrice);
	}
	public void setBuyCurrency(String buyCurrency){
		this.buyCurrency = buyCurrency;
	}
	public void setStockOnHand(String stockOnHand){
		this.stockOnHand = Integer.parseInt(stockOnHand);
	}
	public void setStockOnOrder(String stockOnOrder){
		this.stockOnOrder= Integer.parseInt(stockOnOrder);
	}
	public void setLeadTime(String leadTime){
		this.leadTime = Integer.parseInt(leadTime);
	}
	
	//those get method
	public int getRecordsIndex(){
		return recordsIndex;
	}
	public int getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String getCategory(){
		return category;
	}
	
	public String getSubCategory(){
		return subCategory;
	}
	public String getBrand(){
		return brand;
	}
	public String getSupplier(){
		return supplier;
	}
	public double getMinOrderQuantity(){
		return minOrderQuantity;
	}
	public double getTargetBatchVolume(){
		return targetBatchVolume;
	}
	public double getVolume(){
		return volume;
	}
	public double getSellPrice(){
		return sellPrice;
	}	
	public String getSellCurrency(){
		return sellCurrency;
	}
	public double getBuyPrice(){
		return buyPrice;
	}
	public String getBuyCurrency(){
		return buyCurrency;
	}
	public int getStockOnHand(){
		return stockOnHand;
	}
	public int getStockOnOrder(){
		return stockOnOrder;
	}
	public int getLeadTime(){
		return leadTime;
	}
	
}