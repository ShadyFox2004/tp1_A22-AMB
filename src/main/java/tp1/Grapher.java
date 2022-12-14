package tp1;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.List;


public class Grapher {

    /**
     * @author Antoine-Matis Boudreau
     * @author Francois Marchand
     *
     * creates a series using the data provided.
     *
     * @param params
     * @return the Series data
     */
    public XYChart.Series<Number, Number> createGraph(Parameters params) {
        XYChart.Series<Number,Number> xyChart = new XYChart.Series<Number,Number>();

        for (int i = 0; i < params.xList.size(); i++) {
            xyChart.getData().add(new XYChart.Data<Number,Number>(params.xList.get(i),params.yList.get(i)));
        }

        return xyChart;
    }

    public static class Parameters {

        private List<Number> xList;
        private List<Number> yList;
        private final String name;

        public Parameters(List<Number> xList, List<Number> yList, String name) {
            this.xList = xList;
            this.yList = yList;
            this.name = name;
        }

        public List<Number> getxList() {
            return xList.stream().toList();
        }

        public List<Number> getyList() {
            return yList;
        }

        public String getName() {
            return name;
        }
    }
}
