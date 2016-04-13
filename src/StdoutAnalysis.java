import soot.*;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.scalar.ForwardFlowAnalysis;

public class StdoutAnalysis extends ForwardFlowAnalysis<Unit, Object> {

  public StdoutAnalysis(DirectedGraph<Unit> graph) {
    super(graph);
  }

  @Override
  protected void flowThrough(Object in, Unit d, Object out) {
  }

  @Override
  protected Object newInitialFlow() {
    return null;
  }

  @Override
  protected void merge(Object in1, Object in2, Object out) {
  }

  @Override
  protected void copy(Object source, Object dest) {
  }

  public void run() {
    doAnalysis();
  }
}
