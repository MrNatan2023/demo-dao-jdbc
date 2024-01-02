package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;


public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        System.out.println();  System.out.println();

        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list){
            System.out.println(obj);
        }
        System.out.println();  System.out.println();

        list = sellerDao.findAll();
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println();  System.out.println();

        Seller newSeller = new Seller(null, "Greg" ,"greg@gmail.com",new Date(),4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println(newSeller.getId());

    }
}
