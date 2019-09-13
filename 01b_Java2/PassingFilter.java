public class PassingFilter implements FloatFilter {
    public boolean match(float value) {
        if (value >= 50.0f) {
            return true;
        } else {
            return false;
        }
    }
}