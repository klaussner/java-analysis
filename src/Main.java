import soot.*;
import soot.options.*;
import soot.toolkits.graph.ExceptionalUnitGraph;

public class Main {
  static {
    Options opt = Options.v();

    opt.set_soot_classpath(".");
    opt.set_prepend_classpath(true);
    opt.set_whole_program(true);
  }

  public static void main(String... args) {
    Scene s = Scene.v();

    SootClass c = s.loadClassAndSupport("Demo");
    s.loadNecessaryClasses();

    SootMethod main = null;
    ExceptionalUnitGraph graph;
    StdoutAnalysis analysis;

    for (SootMethod method : c.getMethods()) {
      if (method.getName().equals("main")) {
        main = method;
        break;
      }
    }

    if (main == null) {
      throw new RuntimeException("No main method");
    }

    graph = new ExceptionalUnitGraph(main.retrieveActiveBody());
    analysis = new StdoutAnalysis(graph);

    analysis.run();
  }
}
