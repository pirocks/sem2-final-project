package ui.view.planet;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by bob on 5/18/2016.
 */
public class MountainController implements Initializable {
	@FXML
	Group group;
	@FXML
	AnchorPane anchorPane;
	/**
	 * Called to initialize a controller after its root element has been
	 * completely processed.
	 *
	 * @param location  The location used to resolve relative paths for the root object, or
	 *                  <tt>null</tt> if the location is not known.
	 * @param resources The resources used to localize the root object, or <tt>null</tt> if
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		anchorPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode())
				{
					case ENTER:
						break;
					case BACK_SPACE:
						break;
					case TAB:
						break;
					case CANCEL:
						break;
					case CLEAR:
						break;
					case SHIFT:
						break;
					case CONTROL:
						break;
					case ALT:
						break;
					case PAUSE:
						break;
					case CAPS:
						break;
					case ESCAPE:
						break;
					case SPACE:
						break;
					case PAGE_UP:
						System.out.print("up");
						break;
					case PAGE_DOWN:
						break;
					case END:
						break;
					case HOME:
						break;
					case LEFT:
						break;
					case UP:
						break;
					case RIGHT:
						break;
					case DOWN:
						break;
					case COMMA:
						break;
					case MINUS:
						break;
					case PERIOD:
						break;
					case SLASH:
						break;
					case DIGIT0:
						break;
					case DIGIT1:
						break;
					case DIGIT2:
						break;
					case DIGIT3:
						break;
					case DIGIT4:
						break;
					case DIGIT5:
						break;
					case DIGIT6:
						break;
					case DIGIT7:
						break;
					case DIGIT8:
						break;
					case DIGIT9:
						break;
					case SEMICOLON:
						break;
					case EQUALS:
						break;
					case A:
						break;
					case B:
						break;
					case C:
						break;
					case D:
						break;
					case E:
						break;
					case F:
						break;
					case G:
						break;
					case H:
						break;
					case I:
						break;
					case J:
						break;
					case K:
						break;
					case L:
						break;
					case M:
						break;
					case N:
						break;
					case O:
						break;
					case P:
						break;
					case Q:
						break;
					case R:
						break;
					case S:
						break;
					case T:
						break;
					case U:
						break;
					case V:
						break;
					case W:
						break;
					case X:
						break;
					case Y:
						break;
					case Z:
						break;
					case OPEN_BRACKET:
						break;
					case BACK_SLASH:
						break;
					case CLOSE_BRACKET:
						break;
					case NUMPAD0:
						break;
					case NUMPAD1:
						break;
					case NUMPAD2:
						break;
					case NUMPAD3:
						break;
					case NUMPAD4:
						break;
					case NUMPAD5:
						break;
					case NUMPAD6:
						break;
					case NUMPAD7:
						break;
					case NUMPAD8:
						break;
					case NUMPAD9:
						break;
					case MULTIPLY:
						break;
					case ADD:
						break;
					case SEPARATOR:
						break;
					case SUBTRACT:
						break;
					case DECIMAL:
						break;
					case DIVIDE:
						break;
					case DELETE:
						break;
					case NUM_LOCK:
						break;
					case SCROLL_LOCK:
						break;
					case F1:
						break;
					case F2:
						break;
					case F3:
						break;
					case F4:
						break;
					case F5:
						break;
					case F6:
						break;
					case F7:
						break;
					case F8:
						break;
					case F9:
						break;
					case F10:
						break;
					case F11:
						break;
					case F12:
						break;
					case F13:
						break;
					case F14:
						break;
					case F15:
						break;
					case F16:
						break;
					case F17:
						break;
					case F18:
						break;
					case F19:
						break;
					case F20:
						break;
					case F21:
						break;
					case F22:
						break;
					case F23:
						break;
					case F24:
						break;
					case PRINTSCREEN:
						break;
					case INSERT:
						break;
					case HELP:
						break;
					case META:
						break;
					case BACK_QUOTE:
						break;
					case QUOTE:
						break;
					case KP_UP:
						break;
					case KP_DOWN:
						break;
					case KP_LEFT:
						break;
					case KP_RIGHT:
						break;
					case DEAD_GRAVE:
						break;
					case DEAD_ACUTE:
						break;
					case DEAD_CIRCUMFLEX:
						break;
					case DEAD_TILDE:
						break;
					case DEAD_MACRON:
						break;
					case DEAD_BREVE:
						break;
					case DEAD_ABOVEDOT:
						break;
					case DEAD_DIAERESIS:
						break;
					case DEAD_ABOVERING:
						break;
					case DEAD_DOUBLEACUTE:
						break;
					case DEAD_CARON:
						break;
					case DEAD_CEDILLA:
						break;
					case DEAD_OGONEK:
						break;
					case DEAD_IOTA:
						break;
					case DEAD_VOICED_SOUND:
						break;
					case DEAD_SEMIVOICED_SOUND:
						break;
					case AMPERSAND:
						break;
					case ASTERISK:
						break;
					case QUOTEDBL:
						break;
					case LESS:
						break;
					case GREATER:
						break;
					case BRACELEFT:
						break;
					case BRACERIGHT:
						break;
					case AT:
						break;
					case COLON:
						break;
					case CIRCUMFLEX:
						break;
					case DOLLAR:
						break;
					case EURO_SIGN:
						break;
					case EXCLAMATION_MARK:
						break;
					case INVERTED_EXCLAMATION_MARK:
						break;
					case LEFT_PARENTHESIS:
						break;
					case NUMBER_SIGN:
						break;
					case PLUS:
						break;
					case RIGHT_PARENTHESIS:
						break;
					case UNDERSCORE:
						break;
					case WINDOWS:
						break;
					case CONTEXT_MENU:
						break;
					case FINAL:
						break;
					case CONVERT:
						break;
					case NONCONVERT:
						break;
					case ACCEPT:
						break;
					case MODECHANGE:
						break;
					case KANA:
						break;
					case KANJI:
						break;
					case ALPHANUMERIC:
						break;
					case KATAKANA:
						break;
					case HIRAGANA:
						break;
					case FULL_WIDTH:
						break;
					case HALF_WIDTH:
						break;
					case ROMAN_CHARACTERS:
						break;
					case ALL_CANDIDATES:
						break;
					case PREVIOUS_CANDIDATE:
						break;
					case CODE_INPUT:
						break;
					case JAPANESE_KATAKANA:
						break;
					case JAPANESE_HIRAGANA:
						break;
					case JAPANESE_ROMAN:
						break;
					case KANA_LOCK:
						break;
					case INPUT_METHOD_ON_OFF:
						break;
					case CUT:
						break;
					case COPY:
						break;
					case PASTE:
						break;
					case UNDO:
						break;
					case AGAIN:
						break;
					case FIND:
						break;
					case PROPS:
						break;
					case STOP:
						break;
					case COMPOSE:
						break;
					case ALT_GRAPH:
						break;
					case BEGIN:
						break;
					case UNDEFINED:
						break;
					case SOFTKEY_0:
						break;
					case SOFTKEY_1:
						break;
					case SOFTKEY_2:
						break;
					case SOFTKEY_3:
						break;
					case SOFTKEY_4:
						break;
					case SOFTKEY_5:
						break;
					case SOFTKEY_6:
						break;
					case SOFTKEY_7:
						break;
					case SOFTKEY_8:
						break;
					case SOFTKEY_9:
						break;
					case GAME_A:
						break;
					case GAME_B:
						break;
					case GAME_C:
						break;
					case GAME_D:
						break;
					case STAR:
						break;
					case POUND:
						break;
					case POWER:
						break;
					case INFO:
						break;
					case COLORED_KEY_0:
						break;
					case COLORED_KEY_1:
						break;
					case COLORED_KEY_2:
						break;
					case COLORED_KEY_3:
						break;
					case EJECT_TOGGLE:
						break;
					case PLAY:
						break;
					case RECORD:
						break;
					case FAST_FWD:
						break;
					case REWIND:
						break;
					case TRACK_PREV:
						break;
					case TRACK_NEXT:
						break;
					case CHANNEL_UP:
						break;
					case CHANNEL_DOWN:
						break;
					case VOLUME_UP:
						break;
					case VOLUME_DOWN:
						break;
					case MUTE:
						break;
					case COMMAND:
						break;
					case SHORTCUT:
						break;
				}
			}
		});
	}
}
