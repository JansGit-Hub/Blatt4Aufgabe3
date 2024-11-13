public class TableViewController implements IControllerInterface{
    private IModelInterface m_model;


    public TableViewController(IModelInterface model){
        this.m_model = model;
    }
    @Override
    public void setValues(String red, String green, String blue) {
        int r = 0;
        int g = 0;
        int b = 0;

        b = Integer.parseInt(blue);

        g = Integer.parseInt(green);

        r = Integer.parseInt(red);

        m_model.setBlueValue(b);
        m_model.setRedValue(r);
        m_model.setGreenValue(g);
    }
}