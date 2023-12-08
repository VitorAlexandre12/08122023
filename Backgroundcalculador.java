package fibo;
import javax.swing.SwingWorker;
import javax.swing.JLabel;
import java.util.concurrent.ExecutionException;

public class Backgroundcalculador extends SwingWorker<Long, Object>{
    private final int n;
    private final JLabel;

    public Backgroundcalculador (int n, JLabel resultJLabel)
    {
        this.n = n;
        this.resultJLabel = resultJLabel;
    }

    public Long doInBackground ()
    {
        long nthFib;
        return nthFib = fibonacci(n);
    }

    protected void done()
    {
        try
        {
            resultJLabel.setText(get().toString());
        }
        catch(InterruptedException ex)
        {
            resultJLabel.setText("error encountered while performing calculation.");
        }
    }

    public long fibonacci(long number)
    {
        if (number == 0 || number == 1) 
            return number;
            else
            return fibonacci(number -1) + fibonacci(number - 2);
        
    }
}
