package week2;

import week2.dao.CarDaoImpl;
import week2.dao.CustomerDaoImpl;
import week2.dao.OrderDaoImpl;
import week2.dao.OrderDetailsDaoImpl;
import week2.util.Util;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class LuxCars {

    public static void main(String[] args) throws SQLException {
        //Util.connection();

        CustomerDaoImpl cdao = new CustomerDaoImpl();
        CarDaoImpl carDao = new CarDaoImpl();
        OrderDaoImpl orderDao = new OrderDaoImpl();
        OrderDetailsDaoImpl orderDetailsDao = new OrderDetailsDaoImpl();
 //       orderDetailsDao.getAllOrderDetails();
//        orderDao.createOrdersTable();
//        orderDao.dropOrdersTable();
//        orderDao.saveOrder(LocalDateTime.now(),1L);
//        orderDao.saveOrder(LocalDateTime.now(), 2L);
//        orderDao.saveOrder(LocalDateTime.now(), 3L);
//        orderDao.saveOrder(LocalDateTime.now(), 4L);
//        orderDao.updateOrder(4L, LocalDateTime.now(),3L);
//        orderDao.deleteOrderById(7L);
//        orderDao.getOrderById(2L);
       // orderDao.getAllOrders();
//        cdao.createCustomersTable();
//        carDao.createCarsTable();

//        orderDetailsDao.saveOrderDetail(LocalDateTime.now(),5.5,1L, 1L);
        orderDetailsDao.saveOrderDetail(LocalDateTime.now(),4.5,2L, 2L);
        orderDetailsDao.saveOrderDetail(LocalDateTime.now(),6.5,3L, 3L);
        orderDetailsDao.saveOrderDetail(LocalDateTime.now(),18.5,8L, 4L);
//        cdao.saveCustomer("azart", "azatov", "aza@mail.com", "+99640658798");
//        cdao.updateCustomer(3L, "vano", "vanyaev", "van@mail.com", "+99641201587");
//        carDao.saveCar("Mers", "124", 1995, 5.500);
//        cdao.saveCustomer("bazar", "batov", "bata@mail.com", "+99687412791");
//        carDao.saveCar("BMW", "34", 1992, 4.500);
//       cdao.saveCustomer("mert", "mertov", "mer@mail.com", "+99646985323");
//        carDao.saveCar("Toyota", "chaser", 1999, 6.500);
//        cdao.saveCustomer("wago", "wagaev", "wga@mail.com", "+99680014206");
//        carDao.saveCar("Lexus", "lx 470", 2005, 18.500);
//        cdao.dropCustomersTable();
//        cdao.getCustomerById(1L);
//        cdao.getAllCustomers();
 //       carDao.getAllCars();
        // cdao.updateCustomer(2L, "wero", "wer@mail.com");
    }
}
