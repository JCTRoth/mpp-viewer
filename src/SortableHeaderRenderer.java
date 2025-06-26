import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * A simple pass-through renderer that delegates to the original renderer
 */
public class SortableHeaderRenderer implements TableCellRenderer {
    private TableCellRenderer delegate;
    private int sortColumn = -1;
    private boolean ascending = true;

    public SortableHeaderRenderer(TableCellRenderer delegate) {
        this.delegate = delegate;
    }

    public void setSortColumn(int sortColumn, boolean ascending) {
        this.sortColumn = sortColumn;
        this.ascending = ascending;
        if (delegate instanceof CustomTableHeaderRenderer) {
            ((CustomTableHeaderRenderer) delegate).setSortState(sortColumn, ascending);
        }
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (delegate instanceof CustomTableHeaderRenderer) {
            ((CustomTableHeaderRenderer) delegate).setSortState(sortColumn, ascending);
        }
        return delegate.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);
    }
}
