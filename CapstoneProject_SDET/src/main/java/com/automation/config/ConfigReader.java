package com.automation.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigReader – loads config.properties once at class load time.
 *
 * Usage:
 *   String url = ConfigReader.baseUrl();
 *   String val = ConfigReader.get("any.key");
 */
public final class ConfigReader {

    private static final Properties PROPS = new Properties();
    private static final String     FILE  = "src/test/resources/config.properties";

    static {
        try (FileInputStream fis = new FileInputStream(FILE)) {
            PROPS.load(fis);
        } catch (IOException e) {
            throw new ExceptionInInitializerError(
                "Could not load config.properties from: " + FILE + " → " + e.getMessage());
        }
    }

    private ConfigReader() { }

    /** Raw key lookup; throws if absent. */
    public static String get(String key) {
        String v = PROPS.getProperty(key);
        if (v == null || v.isBlank())
            throw new RuntimeException("Missing key in config.properties: " + key);
        return v.trim();
    }

    // ── typed shortcuts ──────────────────────────────────────
    public static String  baseUrl()             { return get("base.url"); }
    public static String  browser()             { return get("browser").toLowerCase(); }
    public static boolean headless()            { return Boolean.parseBoolean(get("headless")); }
    public static int     implicitWait()        { return Integer.parseInt(get("implicit.wait")); }
    public static int     explicitWait()        { return Integer.parseInt(get("explicit.wait")); }
    public static int     pageLoadTimeout()     { return Integer.parseInt(get("page.load.timeout")); }
    public static boolean screenshotOnFailure() { return Boolean.parseBoolean(get("screenshot.on.failure")); }
    public static String  screenshotDir()       { return get("screenshot.dir"); }
    public static String  reportDir()           { return get("report.dir"); }
    public static String  testName()            { return get("test.name"); }
    public static String  testEmail()           { return get("test.email"); }
    public static String  testPhone()           { return get("test.phone"); }
    public static String  testAddress()         { return get("test.address"); }
}