import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;

/*
 *  The ActionMapAction class is a convenience class that allows you to use
 *  an installed Action as an Action or ActionListener on a separate component.
 *
 *  It can be used on components like JButton or JMenuItem that support an
 *  Action as a property of the component. Or it can be added to the same
 *  above components as an ActionListener.
 *
 *  The benefit of this class is that a new ActionEvent will be created such
 *  that the source of the event is the component the Action belongs to, not
 *  the component that was "clicked". Otherwise in many cases a
 *  ClassCastException will be thrown when the Action is invoked.
 */
public class ActionMapAction extends AbstractAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Action originalAction;
	private final JComponent component;
	private String actionCommand = "";

	/**
	 *  Replace the default Action for the given KeyStroke with a custom Action
	 *
	 *  @param name       the name parameter of the Action
	 *  @param component   the component the Action belongs to
	 *  @param actionKey  the key to identify the Action in the ActionMap
	 */
	public ActionMapAction(String name, JComponent component, String actionKey)
	{
		super(name);

		originalAction = component.getActionMap().get(actionKey);

		if (originalAction == null)
		{
			String message = "no Action for action key: " + actionKey;
			throw new IllegalArgumentException(message);
		}

		this.component = component;
	}

	public void setActionCommand(String actionCommand)
	{
		this.actionCommand = actionCommand;
	}

	/**
	 *  Invoke the original Action using the original component as the source
	 *  of the event.
	 */
	public void actionPerformed(ActionEvent e)
	{
		e = new ActionEvent(
			component,
			ActionEvent.ACTION_PERFORMED,
			actionCommand,
			e.getWhen(),
			e.getModifiers());

		originalAction.actionPerformed(e);
	}
}