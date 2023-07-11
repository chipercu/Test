package org.example.Reflection_1.Config;

public class JavaConfig implements Config{
    @Override
    public String getPackageToScan() {
        return "org/example/Reflection_1/Pages";
    }
}
