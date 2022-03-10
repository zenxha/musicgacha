public interface Functor
{
    public void execute();
}

public class Method1 implements Functor
{
    public void execute() { /* do something */ }
}

etc...


private Functor[] f = { new Method1(), new Method2(), new Method3() };

        ...

// Execute the method selected by i
        f[i].execute();