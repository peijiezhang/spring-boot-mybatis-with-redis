package com.wooyoo.learning;


import com.wooyoo.learning.model.dto.CommTree;
import com.wooyoo.learning.model.dto.FileTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles(profiles = "test")
public class SpringBootMybatisWithRedisApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test() {
      /*  long productId = 1;
        Product product = restTemplate.getForObject("http://localhost:" + port + "/product/" + productId, Product.class);
        assertThat(product.getPrice()).isEqualTo(200);

        Product newProduct = new Product();
        long newPrice = new Random().nextLong();
        newProduct.setName("new name");
        newProduct.setPrice(newPrice);
        restTemplate.put("http://localhost:" + port + "/product/" + productId, newProduct);

        Product testProduct = restTemplate.getForObject("http://localhost:" + port + "/product/" + productId, Product.class);
        assertThat(testProduct.getPrice()).isEqualTo(newPrice);*/
    }

    @Test
    public void testFile(){

        String path = "C:\\data";

        FileTree mainFileTree = new FileTree();
        /*Object childrenFile = getChildrenFile(path, mainFileTree);
        System.out.println("childrenList====>"+childrenFile);*/




    }


    /*public Object  getChildrenFile(String path, FileTree fileTree) {


        List<FileTree> mainTreeList  = new LinkedList<>();
        List<FileTree>  childTreeList  = new LinkedList<>();

        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {

                System.out.println("文件夹是空的!");

            } else {
                for (File detailFile : files) {
                    FileTree childrenTree = new FileTree();
                    if (detailFile.isDirectory()) {
                        //childrenTree.setLeaf(false);
                        childrenTree.setDirectory(detailFile.getName());
                        childrenTree.setText(detailFile.getName());
                        childTreeList.add(childrenTree);
                        fileTree.setChildren(childTreeList);

                        getChildrenFile(detailFile.getPath(),childrenTree);
                    } else {

                        fileTree.setLeaf(true);
                        childrenTree.setText(detailFile.getName());
                        childrenTree.setFileName(detailFile.getName());
                        childTreeList.add(childrenTree);
                        fileTree.setChildren(childTreeList);

                    }

                }

                mainTreeList.add(fileTree);
            }
        } else {
             System.out.println("文件不存在!");
        }
        return  mainTreeList;
    }*/



}
