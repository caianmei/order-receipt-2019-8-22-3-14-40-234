package org.katas.refactoring;

public class OrderReceipt {
    private Order o;

    public OrderReceipt(Order o) {
        this.o = o;
    }
    
    private String printHeaders() {
		return "======Printing Orders======\n";
	}
    
    private String printCustomerName() {
		return o.getCustomerName();
	}

    private String printCustomerAddress() {
		return o.getCustomerAddress();
	}
    
    private String printsLineItem(LineItem lineItem) {
		return lineItem.getDescription()+'\t'+lineItem.getPrice() + '\t' +lineItem.getQuantity() +'\t' +lineItem.totalAmount() + '\n';
	}
    
    private String printTotPrice(double totSalesTx,double tot) {
    	return  "Sales Tax" + '\t'+ totSalesTx + "Total Amount" + '\t'+ tot;
    }
    private String calculateSalesTax() {
    	double totSalesTx = 0d;
        double tot = 0d;
        double discount = .10;
		for (LineItem lineItem : o.getLineItems()) {
            double salesTax = lineItem.totalAmount() * discount;
            totSalesTx += salesTax;
            tot += lineItem.totalAmount() + salesTax;
		}		
	   return printTotPrice(totSalesTx,tot);
	}
    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        output.append(printHeaders() + printCustomerName() + printCustomerAddress());
     
        for (LineItem lineItem : o.getLineItems()) {
            output.append(printsLineItem(lineItem));            
        }

        output.append(calculateSalesTax());
        return output.toString();
    }
}