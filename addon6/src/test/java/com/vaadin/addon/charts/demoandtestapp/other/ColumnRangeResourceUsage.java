package com.vaadin.addon.charts.demoandtestapp.other;

import java.util.Calendar;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.demoandtestapp.AbstractVaadinChartExample;
import com.vaadin.addon.charts.model.AxisType;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.DataSeries;
import com.vaadin.addon.charts.model.DataSeriesItem;
import com.vaadin.addon.charts.model.PlotOptionsColumnRange;
import com.vaadin.addon.charts.model.Tooltip;
import com.vaadin.addon.charts.model.XAxis;
import com.vaadin.addon.charts.model.YAxis;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
public class ColumnRangeResourceUsage extends AbstractVaadinChartExample {

    @Override
    public String getDescription() {
        return "Area Range visualizing resource usage";
    }

    @Override
    protected Component getChart() {
        Chart chart = new Chart(ChartType.COLUMNRANGE);

        Configuration conf = chart.getConfiguration();
        conf.setTitle("Resource usage");
        conf.getChart().setInverted(true);

        XAxis xAxis = new XAxis();
        xAxis.setCategories("Printer", "Coffee mahine");
        conf.addxAxis(xAxis);

        YAxis yAxis = new YAxis();
        yAxis.setTitle("Time");
        yAxis.setType(AxisType.DATETIME);
        conf.addyAxis(yAxis);
        
        Tooltip tooltip = new Tooltip();
        tooltip.setFormatter("this.series.name +': '+ Highcharts.dateFormat('%H:%M', this.point.low) + ' - ' + Highcharts.dateFormat('%H:%M', this.point.high)");
        conf.setTooltip(tooltip);


        PlotOptionsColumnRange columnRange = new PlotOptionsColumnRange();
        columnRange.setGrouping(false);
        
        conf.setPlotOptions(columnRange);
        
        
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.MILLISECOND, 0);
        instance.set(2013, 6, 7, 12, 00, 00);

        DataSeries a = new DataSeries();
        a.setName("Team Alpha");
        PlotOptionsColumnRange o = new PlotOptionsColumnRange();
        o.setColor(new SolidColor(255, 60, 125, 0.8));
        a.setPlotOptions(o);
        DataSeries b = new DataSeries();
        o = new PlotOptionsColumnRange();
        o.setColor(new SolidColor(60, 125, 255, 0.8));
        b.setPlotOptions(o);
        b.setName("Team Beta");

        DataSeriesItem item;

        item = new DataSeriesItem();
        item.setName("Printer");
        item.setLow(instance.getTimeInMillis());
        instance.roll(Calendar.HOUR_OF_DAY, 3);
        item.setHigh(instance.getTimeInMillis());
        a.add(item);
        
        item = new DataSeriesItem();
        item.setName("Printer");
        instance.roll(Calendar.HOUR_OF_DAY, 1);
        item.setLow(instance.getTimeInMillis());
        instance.roll(Calendar.HOUR_OF_DAY, 1);
        item.setHigh(instance.getTimeInMillis());
        b.add(item);

        instance.set(2013, 6, 7, 12, 00, 00);
        item = new DataSeriesItem();
        item.setName("Coffee mahine");
        item.setLow(instance.getTimeInMillis());
        instance.roll(Calendar.HOUR_OF_DAY, 2);
        item.setHigh(instance.getTimeInMillis());
        b.add(item);
        
        item = new DataSeriesItem();
        item.setName("Coffee mahine");
        instance.roll(Calendar.HOUR_OF_DAY, -1);
        item.setLow(instance.getTimeInMillis());
        instance.roll(Calendar.HOUR_OF_DAY, 4);
        item.setHigh(instance.getTimeInMillis());
        a.add(item);

        conf.setSeries(a,b);
        
        return chart;
    }
}