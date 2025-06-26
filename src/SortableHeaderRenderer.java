import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * A simple pass-through renderer that delegates to the original renderer
 */
public class SortableHeaderRenderer implements TableCellRenderer {
    private TableCellRenderer delegate;

    public SortableHeaderRenderer(TableCellRenderer delegate) {
        this.delegate = delegate;
    }

    public void setSortColumn(int sortColumn, boolean ascending) {
        // Do nothing - sorting feature removed
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        // Simply pass through to the original renderer without modifications
        return delegate.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);
    }
}
