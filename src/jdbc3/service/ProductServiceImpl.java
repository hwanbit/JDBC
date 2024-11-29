package jdbc3.service;

import jdbc3.entity.Product;
import jdbc3.repository.ProductRepository;
import jdbc3.view.ProductView;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductServiceImpl implements ProductService {
    public void search(Scanner s1, Scanner s2) {
        System.out.print("* 검색 종류를 선택하세요. (1.제품명   2.제조업체) : ");
        int searchType = s1.nextInt();

        String type = "제품명";
        switch (searchType) {
            case 1 :
                type = "제품명";
                break;
            case 2 :
                type = "제조업체";
                break;
        }

        System.out.print("* 검색어를 입력하세요. : ");
        String searchWord = s2.nextLine();

        ArrayList<Product> arrList = ProductRepository.getList(type, searchWord);
        ProductView.printView(arrList);
    }
}