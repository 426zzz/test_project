package org.lyz.test_project.test;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class IOTest {

	// 读取文本
	public static void fileInputStream() {
		FileInputStream fis = null;
		try {
			// 创建输入流对象，1.txt中内容为'java is ok'
			fis = new FileInputStream(new File("F:\\1.txt"));
			// read();
			int r1 = fis.read(); // 获取1.txt中的第一个字节
			System.out.println((char)r1); // 输出'j'
			
			// read(byte [])
			byte[] b = new byte[2];
			String result = "";
			int i = 1;
			while(fis.read(b) != -1) {
				System.out.print("第"+ i +"次读取2个字节");
				result += new String(b, 0, b.length);
				System.out.println("此次读取内容为：" + new String(b, 0, b.length));
				i++;
			}
			/*
			第1次读取2个字节此次读取内容为：ja
        	第2次读取2个字节此次读取内容为：va
        	第3次读取2个字节此次读取内容为： i
        	第4次读取2个字节此次读取内容为：s
        	第5次读取2个字节此次读取内容为：ok
        	java is ok
        	*/
			System.out.println(result);
			
			byte[] b2 = new byte[2];
			String result2 = "";
			int i2 = 0;
			while(fis.read(b2, 1, b2.length -1) != -1) { // 此处注意数组越界，偏移量大小 + 读取字节大小不得 > 数组
				System.out.print("第"+ i2 +"次读取2个字节");
				result2 += new String(b2, 0, b2.length);
				System.out.println("此次读取内容为：" + new String(b2, 0, b2.length));
				i2++;
			}
			/*注意空格
			第0次读取2个字节此次读取内容为： j
			第1次读取2个字节此次读取内容为： a
			第2次读取2个字节此次读取内容为： v
			第3次读取2个字节此次读取内容为： a
			第4次读取2个字节此次读取内容为：
			第5次读取2个字节此次读取内容为： i
			第6次读取2个字节此次读取内容为： s
			第7次读取2个字节此次读取内容为：
			第8次读取2个字节此次读取内容为： o
			第9次读取2个字节此次读取内容为： k
			 j a v a   i s   o k
			*/
			System.out.println(result2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 输出文本
	public static void fileOutputStream() {
		FileOutputStream fio = null;
		try {
			fio = new FileOutputStream("F:\\1.txt");
			// write(int)
			fio.write(65); // A
			
			// write(byte[])
			fio.write("ABC".getBytes()); // ABC
			
			// write(byte[], offset, len)
			fio.write("ABCDEFG".getBytes(), 2, 2); // CD
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fio != null) {
				try {
					fio.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
	}

	// 复制文件
	public static void copyFile() {
		FileInputStream fis = null;
		BufferedInputStream bi = null;
		FileOutputStream fio = null;
		BufferedOutputStream bo = null;
		try {
			fis = new FileInputStream("F:\\1.txt");
			bi = new BufferedInputStream(fis);
			fio = new FileOutputStream("F:\\2.txt");
			bo = new BufferedOutputStream(fio);
			byte[] arr = new byte[1024]; // 尽量使用自定义缓存与处理流
			int len = 0;
			while((len = fis.read(arr)) != -1) {
				bo.write(arr, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(bo != null) {
				try {
					bo.close();// BufferedOutputStream中close()方法自带flush()；
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(fio != null){
				try {
					fio.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(bi != null) {
				try {
					bi.close(); 
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(fis != null) {
				try {
					fis.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}

	// 简单压缩
	public static void compress() {
		// 只压缩批量文件，有文件夹的压缩需要递归
		File path = new File("F:\\test"); // 被压缩文件目录
		File[] files = path.listFiles(); // 被压缩文件目录文件
		String zipPath = "F:\\test\\test.zip"; // 压缩文件存放目录
		// 先读后写
		FileInputStream fis = null;
		BufferedInputStream bi = null;
		ZipOutputStream zo = null;
		BufferedOutputStream bo = null;
		try {
			zo = new ZipOutputStream(new FileOutputStream(new File(zipPath)));
			bo = new BufferedOutputStream(zo);
			for(int i = 0; i < files.length; i++) {
				zo.putNextEntry(new ZipEntry(files[i].getName())); // 以文件名创建压缩节点
				fis = new FileInputStream(files[i]);
				bi = new BufferedInputStream(fis);
				int arr = 0;
				while(( arr = bi.read() ) != -1 ) {
					bo.write(arr);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(bi != null) {
				try {
					bi.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(bo != null) {
				try {
					bo.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(zo != null) {
				try {
					zo.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
//		fileInputStream();
//		fileOutputStream();
//		copyFile();
//		compress();
 	}
}
