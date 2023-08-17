package vos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class SelectQueryVO {
	 private String dateStart;
     private String dateLast;
     private String contentType;
     private String lowPrice;
     private String highPrice;
     private String receiptNum;
}
