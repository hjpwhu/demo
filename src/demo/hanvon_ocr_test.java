package demo;

import com.hanvon.ccb.ocr.HavnonRecgEngine;
import com.hanvon.ccb.ocr.RecoResult;
import com.hanvon.ccb.ocr.bankcard.BankCardRecoResult;



public class hanvon_ocr_test {

	/**
	 * HavnonRecg.recog(String recoType,String filePath)
	 * 汉王OCR识别统一接口，用于识别证照类文件，返回结果为json串
	 * @param recoType 识别的证件类型，字符串类型，“1”代表银行卡，用于对以后其它证照的扩展
	 * @param filePath 要识别文件的绝对路径，通过为jpg格式
	 * @return  返回识别对象RecoResult，可以向下转型为合适的类。
	 */
	public static void main(String[] args) {
		
		System.out.println(System.getProperty("java.library.path")); 
		
		//银行卡
		String strImageFile = "/tmp/bankcard/1.jpg";
		try{
		
		RecoResult recoResult = HavnonRecgEngine.recog("1", strImageFile);//第一个参数1：代表银行卡，用于对以后的扩展，目前只支持银行卡。第二参数为文的路径 
		BankCardRecoResult bankResult = (BankCardRecoResult)recoResult;
		
		
		System.out.println(recoResult.isSuccess());
		System.out.println(recoResult.getMessage());
			System.out.println(recoResult.getJson());
			
			System.out.printf("\n bankname:%s\n cardname:%s\n cardtype:%s\n cardno:%s\n expmonth:%s\n expyear:%s\n",
					bankResult.getBankName(),bankResult.getCardName(),bankResult.getCardType(),bankResult.getCardNo(),
					bankResult.getExpMonth(),bankResult.getExpYear());
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
	}
	
	

}
