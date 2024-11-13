public class MVCTestDrive
{
    public static void main (String[] args)
    {
        DataModel model = new DataModel();
        TableView tableView = new TableView(model);
       // PieChartView pieChartView = new PieChartView(model);
        BarChartView barChartView = new BarChartView(model);
        NumberView nmb = new NumberView(model);
    }
}
