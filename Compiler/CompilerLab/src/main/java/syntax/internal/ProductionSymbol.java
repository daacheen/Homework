package syntax.internal;

import lex.token.TokenType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Symbol of a production
 * can be either a non-terminal or terminal by calling different constructor
 */
@EqualsAndHashCode
public class ProductionSymbol {
    @Getter private String ntName;
    @Getter private TokenType tokenType;

    public ProductionSymbol(String ntName) {
        this.ntName = ntName;
    }

    public ProductionSymbol(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public boolean isNonTerminalSymbol() {
        return ntName != null;
    }

    @Override
    public String toString() {
        if (isNonTerminalSymbol()) {
            return ntName;
        } else {
            return tokenType.name();
        }
    }
}
