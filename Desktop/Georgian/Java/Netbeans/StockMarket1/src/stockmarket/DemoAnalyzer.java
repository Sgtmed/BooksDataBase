/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockmarket;

/**
 *
 * @author Sgtmed
 */
public class DemoAnalyzer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
	{
		ReadFiles.IfFileExists();
		ReadFiles.NumberOfRows();
		ReadFiles.ConvertcsvFileToArray();
		ReadFiles.PrintArray();
		Calculations.PrintDateArray();
		Calculations.PrintDataArray();
                Calculations.Market();
		Calculations.BasicCalculations();
	}
}   