package Personal.Projects.Benchmark.learnJava;
public class myRunnable implements Runnable
{
    @Override
    public void run()
    {
        for(int i = 0; i < 10; i++)
        {
            System.out.println("Thread #2: " + i);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Thread #2 done");
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
    
}
