package test.mvc;

public interface RunnableCommand extends Command, Runnable 
{
	@Override
	public default void run()
	{
		onExecute();
	}
}
