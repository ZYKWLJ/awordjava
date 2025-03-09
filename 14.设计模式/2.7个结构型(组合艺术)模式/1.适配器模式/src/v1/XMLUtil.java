// package v1;
// import javax.xml.parsers.*;
// import org.w3c.dom.*;
// import org.xml.sax.SAXException;
// import java.io.*;
// import java.lang.reflect.Constructor;
// class XMLUtil {
// //该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象
// 	public static Object getBean() {
// 		try {
// 			//创建文档对象
// 			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
// 			DocumentBuilder builder = dFactory.newDocumentBuilder();
// 			Document doc;							
// 			doc = builder.parse(new File("D:\\1code\\java重拾\\awordjava\\14.设计模式\\2.7个结构型(组合艺术)模式\\1.适配器模式\\src\\v1\\config\\config.xml")); 
		
// 			//获取包含类名的文本节点
// 			NodeList nl = doc.getElementsByTagName("className");
//             Node classNode=nl.item(0).getFirstChild();
//             String cName=classNode.getNodeValue();
            
//             //通过类名生成实例对象并将其返回
//             Class c=Class.forName(cName);
//             Constructor<?> constructor = c.getConstructor();
//             return constructor.newInstance();
// 	  	    // Object obj=c.newInstance();
//             // return obj;
//         }   
//         catch(Exception e) {
//            	e.printStackTrace();
//            	return null;
//        	}
// 	}
// }

package v1;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.*;
import java.lang.reflect.Constructor;

class XMLUtil {
    // 该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象
    public static Object getBean() {
        try {
            // 创建文档对象
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("D:\\1code\\java重拾\\awordjava\\14.设计模式\\2.7个结构型(组合艺术)模式\\1.适配器模式\\src\\v1\\config\\config.xml"));

            // 获取 OperationAdapter 类名
            NodeList operationAdapterNodeList = doc.getElementsByTagName("className");
            Node operationAdapterClassNode = operationAdapterNodeList.item(0).getFirstChild();
            String operationAdapterClassName = operationAdapterClassNode.getNodeValue();

            // 获取 QuickSort 类名
            NodeList quickSortNodeList = doc.getElementsByTagName("quickSortClassName");
            Node quickSortClassNode = quickSortNodeList.item(0).getFirstChild();
            String quickSortClassName = quickSortClassNode.getNodeValue();

            // 获取 BinarySearch 类名
            NodeList binarySearchNodeList = doc.getElementsByTagName("binarySearchClassName");
            Node binarySearchClassNode = binarySearchNodeList.item(0).getFirstChild();
            String binarySearchClassName = binarySearchClassNode.getNodeValue();

            // 通过类名获取 Class 对象
            Class<?> operationAdapterClass = Class.forName(operationAdapterClassName);
            Class<?> quickSortClass = Class.forName(quickSortClassName);
            Class<?> binarySearchClass = Class.forName(binarySearchClassName);

            // 创建 QuickSort 和 BinarySearch 实例
            Object quickSortInstance = quickSortClass.getDeclaredConstructor().newInstance();
            Object binarySearchInstance = binarySearchClass.getDeclaredConstructor().newInstance();

            // 获取 OperationAdapter 带两个参数的构造方法
            Constructor<?> constructor = operationAdapterClass.getConstructor(quickSortClass, binarySearchClass);

            // 使用构造方法创建 OperationAdapter 实例
            return constructor.newInstance(quickSortInstance, binarySearchInstance);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}