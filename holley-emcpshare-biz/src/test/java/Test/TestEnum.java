package Test;

public enum TestEnum {

    spring(0, "春天") {

        @Override
        public String crate() {
            return this.getText();
        }
    },
    summer(1, "夏天") {

        @Override
        public String crate() {
            return this.getText();
        }
    };

    private final int    value;
    private final String text;

    TestEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public abstract String crate();
}
