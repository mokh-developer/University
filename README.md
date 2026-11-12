# سیستم مدیریت دانشگاه

پروژه‌ای برای ساخت سیستم مدیریت دانشگاه. این مخزن در حال حاضر اسکلت اولیهٔ برنامه است و قابلیت‌های اصلی هنوز پیاده‌سازی نشده‌اند.

## وضعیت فعلی

- برنامه با Spring Boot راه‌اندازی می‌شود.
- وابستگی‌های وب، اعتبارسنجی، Spring Data JPA و درایور PostgreSQL در پروژه تعریف شده‌اند.
- APIها، مدل‌های دانشگاهی و تنظیم اتصال پایگاه داده هنوز اضافه نشده‌اند.

## فناوری‌ها و پیش‌نیازها

- Java 21 (JDK)
- Maven Wrapper؛ نصب جداگانهٔ Maven لازم نیست.
- PostgreSQL برای زمان افزودن و استفاده از قابلیت‌های پایگاه داده

## اجرا و تست

در ویندوز، از PowerShell در پوشهٔ پروژه:

```powershell
.\mvnw.cmd spring-boot:run
.\mvnw.cmd test
```

در Linux یا macOS:

```bash
./mvnw spring-boot:run
./mvnw test
```

پیش از اجرای برنامه یا تست‌ها، اتصال PostgreSQL را با متغیرهای محیطی Spring تنظیم کنید:

```text
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/university
SPRING_DATASOURCE_USERNAME=<نام کاربری پایگاه داده>
SPRING_DATASOURCE_PASSWORD=<گذرواژه>
```

مقادیر واقعی و گذرواژه‌ها را در مخزن یا فایل‌های عمومی ثبت نکنید.

## همکاری در پروژه

- `main` شاخهٔ پایدار پروژه است؛ تغییرات هر تسک را در شاخهٔ جدا انجام دهید و برای ادغام Pull Request بسازید.
- الگوی نام شاخه: `feature/UNI-12-student-api` یا `fix/UNI-18-course-capacity`.
- پیام کامیت را کوتاه و روشن بنویسید: `type: توضیح کوتاه`.
- نوع‌های پیشنهادی: `feat`، `fix`، `docs`، `test`، `refactor`، `build` و `chore`.

نمونه:

```text
feat: add student registration endpoint
```
