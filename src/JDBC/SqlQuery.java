package JDBC;

public class SqlQuery {
	static String addStockQuery = "INSERT INTO Stock (PRODUCT_ID,PRODUCT_NAME,PORTION_SIZE,DISCOUNT,PRICE,TOTAL_QTY) VALUES (?,?,?,?,?,?)";
	static String addEmpDetailsQuery = "INSERT INTO Employees(ID,First_Name,Last_Name,Phone_No,Email_Id,Password) VALUES (?,?,?,?,?,?)";
	static String fetchPassQuery = "SELECT Password FROM Employees" +" WHERE id = (?)";
	static String deleteEmpAccountQuery = "DELETE FROM Employees" +" WHERE id = (?)";
	static String deleteItemQuery = "DELETE FROM Stock" +" WHERE PRODUCT_NAME = (?) AND PORTION_SIZE = (?)";
	static String modifyPriceQuery = "UPDATE Stock SET PRICE = (?) WHERE PRODUCT_NAME = (?) AND PORTION_SIZE=(?)";
	static String modifyDiscountQuery = "UPDATE Stock "+"SET DISCOUNT = (?)"+" WHERE PRODUCT_NAME = (?)AND PORTION_SIZE=(?)";
	static String fetchTotalStockQuery = "SELECT TOTAL_QTY FROM Stock" +" WHERE PRODUCT_NAME = (?)";
	static String fetchMRPQuery = "SELECT PRICE FROM Stock" +" WHERE PRODUCT_NAME = (?)";
	static String fetchDiscountQuery = "SELECT DISCOUNT FROM Stock" +" WHERE PRODUCT_NAME = (?)";
	static String addToatlStockQuery = "UPDATE Stock SET TOTAL_QTY = TOTAL_QTY+(?) WHERE PRODUCT_NAME = (?) AND PORTION_SIZE=(?)";
	static String fetchTodayDataQuery = "SELECT SUM(TOTAL_AMOUNT),SUM(TOTAL_DISCOUNT),SUM(PAID_AMOUNT) FROM customer WHERE DATE_OF_PURCHASE = CURRENT_DATE";
	static String fetchWeekDataQuery = "SELECT SUM(TOTAL_AMOUNT),SUM(TOTAL_DISCOUNT),SUM(PAID_AMOUNT) FROM customer WHERE DATE_OF_PURCHASE>=DATE_SUB(CURRENT_DATE,INTERVAL 1 WEEK)";
	static String fetchHalfYearDataQuery = "SELECT SUM(TOTAL_AMOUNT),SUM(TOTAL_DISCOUNT),SUM(PAID_AMOUNT) FROM customer WHERE DATE_OF_PURCHASE>=DATE_SUB(CURRENT_DATE,INTERVAL 6 MONTH)";
	static String fetchYearDataQuery = "SELECT SUM(TOTAL_AMOUNT),SUM(TOTAL_DISCOUNT),SUM(PAID_AMOUNT) FROM customer WHERE DATE_OF_PURCHASE>=DATE_SUB(CURRENT_DATE,INTERVAL 1 YEAR)";
	static String fetchProductDetailsQuery="SELECT * FROM stock WHERE PRODUCT_NAME=(?) AND PORTION_SIZE = (?)";
	static String modifyPortionSizeQuery = "UPDATE Stock SET PORTION_SIZE = (?) WHERE PRODUCT_NAME = (?) AND PORTION_SIZE=(?)";
	static String modifyItemIdQuery = "UPDATE Stock SET PRODUCT_ID = (?) WHERE PRODUCT_NAME = (?) AND PORTION_SIZE=(?)";
	static String fetchProductDetailsForOrderQuery="SELECT * FROM stock WHERE TOTAL_QTY>=1";
	static String fetchTotalProduct="select count(TOTAL_QTY) from stock where TOTAL_QTY>=1";
	static String addCustomerQuery = "INSERT INTO customer (FIRST_NAME,LAST_NAME,PHONE_NO,TOTAL_AMOUNT,TOTAL_DISCOUNT,PAID_AMOUNT,DATE_OF_PURCHASE) VALUES (?,?,?,?,?,?,CURRENT_DATE)";
	static String fetchStockDetailsWhereNameQtyQuery = "select * from stock where PRODUCT_NAME=(?) AND PORTION_SIZE = (?)";
	static String addPurchasedData = "INSERT INTO PURCHASED(PRODUCT_NAME,PORTION_SIZE,DISCOUNT,PRICE,TOTAL_QTY ) VALUES (?,?,?,?,?)";
	static String fetchPurchesedDetails = "select * from purchased";
	static String fetchtTotalPurchesedDetails = "select count(PRODUCT_NAME) FROM PURCHASED";
	static String deleteTableContentData = "TRUNCATE TABLE PURCHASED";
	static String decreaceQtyQuery = "UPDATE STOCK SET TOTAL_QTY = TOTAL_QTY- (?) WHERE PRODUCT_NAME=(?) AND PORTION_SIZE=(?)";
	static String checkAvailableInStock = "SELECT COUNT(TOTAL_QTY) from stock WHERE PRODUCT_NAME=(?) AND PORTION_SIZE=(?) AND TOTAL_QTY>=1";
	static String checkProductIdPresentQuery = "SELECT COUNT(PRODUCT_ID) FROM STOCK WHERE PRODUCT_ID=(?)"; 
}