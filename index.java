import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class Eb implements ActionListener{
	
	/* ArrayList tp store all the EB details of the 4 houses, it is of type EBBill(which 
	is implemented later)...*/
	ArrayList<EBBill> billDetailsList;
	
	/* frame to contain all the swing elements */
	JFrame jf;
	
	/* seperate panels one for save data and to show the eb details */
	JPanel toGet, toCalc;
	
	/* textFields and text area for appropriate details */
	JTextField houseNum, nameOfTenent, startReading, endReading, houseNumToCalc;
	JTextArea DetailsOfBill;
	
	JLabel lab_houseNum, lab_nameOfTenent, lab_startReading, lab_endReading, lab_houseNumToCalc, lab_DetailsOfBill, toInform;
	
	/* buttons to execute operations like calculating bill  */
	JButton SaveData, CalculateBill;
	JTextArea Result;
	
	Eb(){
		/* intitalizing all the details */
		billDetailsList= new ArrayList<EBBill>();
			
		jf= new JFrame("EB Bill Calculation");
		toGet= new JPanel();
		toCalc= new JPanel();
		
		/* adding the panels, one to the center and another to the bottom */
		jf.add(toGet, BorderLayout.CENTER);
		jf.add(toCalc, BorderLayout.SOUTH);
		
		/* adding labels to all the text fields to recognize them better*/
		lab_houseNum= new JLabel("House Number");
		houseNum= new JTextField(15);

		lab_nameOfTenent= new JLabel("Name of the tenent");
		nameOfTenent= new JTextField(15);

		lab_startReading= new JLabel("Starting Energy Reading");
		startReading= new JTextField(15);

		lab_endReading= new JLabel("Ending Energy Reading");
		endReading= new JTextField(15);
		
		toInform= new JLabel();
		toInform.setFont(new Font("SANS_SERIF", Font.BOLD, 12));
		toInform.setForeground(Color.RED);
		
		SaveData= new JButton("Save Data");
		SaveData.addActionListener(this);
		
		//Adding all the above details to toGet panel
		toGet.add(lab_houseNum);
		toGet.add(houseNum);

		toGet.add(lab_nameOfTenent);
		toGet.add(nameOfTenent);

		toGet.add(lab_startReading);
		toGet.add(startReading);

		toGet.add(lab_endReading);
		toGet.add(endReading);
		
		toGet.add(toInform);
		toGet.add(SaveData);

		lab_houseNumToCalc= new JLabel("Enter the House number to calculate Bill Amount");
		houseNumToCalc= new JTextField(10);

		lab_DetailsOfBill= new JLabel("Bill Details");
		DetailsOfBill= new JTextArea(20, 20);
		DetailsOfBill.setFont(new Font("SANS_SERIF", Font.BOLD, 12));
		DetailsOfBill.setForeground(Color.RED);
		
		CalculateBill= new JButton("Calculate Bill");
		CalculateBill.addActionListener(this);

		toCalc.add(lab_houseNumToCalc);
		toCalc.add(houseNumToCalc);
		toCalc.add(lab_DetailsOfBill);
		toCalc.add(DetailsOfBill);
		toCalc.add(CalculateBill);
		
		jf.setVisible(true);
		jf.setSize(500, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae){
		String button= ae.getActionCommand();
		
		if(button.equals("Save Data")){
			
			String houseNumber_string= houseNum.getText();
			String name= nameOfTenent.getText();
			String start= startReading.getText();
			String end= endReading.getText();
			
			if(houseNumber_string.equals("") || name.equals("") || start.equals("") || end.equals("")){
				toInform.setText("Please fill all the details. All fields are mandatory.");
				return;
			}
			
			int houseNumber= Integer.parseInt(houseNumber_string);
			int startReading= Integer.parseInt(start);
			int endReading= Integer.parseInt(end);
			
			if(houseNumber > 4 || houseNumber < 1){
				try{
					throw new HouseNotFoundException(houseNumber);
					
				}
				catch(HouseNotFoundException he){
					toInform.setText(he.toString()+ " Please Enter Again");
				}
			}
			
			//Now we can save the data to the list
			else{
				EBBill temp= new EBBill(houseNumber, name, startReading, endReading);
				billDetailsList.add(temp);
				toInform.setText("Details Succesfully saved");
				toInform.setForeground(Color.GREEN);
			}
		
		}
		
		
		else{
			//Calc bill and showing the result
			String houseNum_string= houseNumToCalc.getText();
			
			if(houseNum_string.equals("")){
				DetailsOfBill.setText("House Number should not be Empty");
				return;
			}
			
			int houseNum= Integer.parseInt(houseNum_string);
				
			if(houseNum > 4 || houseNum < 1){
				try{
					throw new HouseNotFoundException(houseNum);
				}
				catch(HouseNotFoundException he){
					DetailsOfBill.setText(he.toString() + " Please Enter Again");
				}				
			}
			
			else{
				//searching through the arrayList for the house number
				EBBill temp= null;
				for(int i= 0;i< billDetailsList.size(); i++){
					temp= billDetailsList.get(i);
					
					if(temp.houseNumber == houseNum){
						//Found the correct house
						temp.calcBillAmount();
						break;
					}
					
				}
				
				String toShow= "House Number : " + temp.houseNumber
								+ "\nName of the Tenent : " + temp.name
								+ "\nStartingReading : " + temp.startingReading
								+ "\nEndingReading : " + temp.endingReading
								+ "\nBill Amount : " + temp.billAmount;
				
				DetailsOfBill.setForeground(Color.GREEN);
				DetailsOfBill.setText(toShow);
			}
		}
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new Eb();				
			}
		});
	}
	
}

class HouseNotFoundException extends Exception{
	int wrongHouseNum;
	
	HouseNotFoundException(int num){
		this.wrongHouseNum= num;
	}
	
	public String toString(){
		return "HouseNotFoundException : The Entered House Number : " + this.wrongHouseNum + " does not exist";
	}
	
}


class EBBill{
	int houseNumber, startingReading, endingReading, billAmount;
	String name;
	
	EBBill(){
		this.houseNumber= 0;
		this.name= "";
		this.startingReading= 0;
		this.endingReading= 0;
		this.billAmount= 0;
	}
	
	EBBill(int num, String name, int start, int end){
		this.houseNumber= num;
		this.name= name;
		this.startingReading= start;
		this.endingReading= end;
	}
	
	public void calcBillAmount(){
		this.billAmount= (this.endingReading - this.startingReading) * 10;
	}
	
}
