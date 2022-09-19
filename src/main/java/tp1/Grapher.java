package tp1;

import javafx.scene.chart.XYChart;

import java.util.List;


public class Grapher {

    public XYChart.Series<Number, Number> createGraph(Parameters params) {
        XYChart.Series xyChart = new XYChart.Series();

        xyChart.setName(params.name);

        for (int i = 0; i < params.xList.size(); i++) {
            xyChart.getData().add(new XYChart.Data(params.xList.get(i),params.yList.get(i)));
        }

        return xyChart;
    }

    public static class Parameters {

        private List<Double> xList;
        private List<Double> yList;
        private final String name;


        public Parameters(List<Double> xList, List<Double> yList, String name) {
            this.xList = xList;
            this.yList = yList;
            this.name = name;
        }

        public List<Double> getxList() {
            return xList;
        }

        public List<Double> getyList() {
            return yList;
        }

        public String getName() {
            return name;
        }
    }
}
