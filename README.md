# My AI Call - Android App

একটি সাধারণ, বিনামূল্যে Android অ্যাপ যা AndroidIDE ব্যবহার করে আপনার Poco C75 ফোনে তৈরি করা যায়।

## বৈশিষ্ট্য
- Java এবং Android XML দিয়ে তৈরি
- বাংলা এবং হিন্দি ভাষা সমর্থন
- সুন্দর এবং পরিষ্কার ইউজার ইন্টারফেস
- AndroidIDE এ সম্পূর্ণভাবে নির্মাণযোগ্য
- বিনামূল্যের সরঞ্জাম এবং লাইব্রেরি ব্যবহার করে

## প্রয়োজনীয়তা
- Android 7.0+ (API 24+)
- AndroidIDE স্থাপিত
- ন্যূনতম 2GB RAM
- ইন্টারনেট সংযোগ (Gradle ডাউনলোডের জন্য)

## প্রকল্প কাঠামো
```
MyAICall/
├─ app/
│  ├─ src/
│  │  ├─ main/
│  │  │  ├─ java/com/myaicall/app/
│  │  │  │  └─ MainActivity.java
│  │  │  ├─ res/
│  │  │  │  ├─ layout/activity_main.xml
│  │  │  │  ├─ drawable/bg_card.xml
│  │  │  │  ├─ values/strings.xml, colors.xml, themes.xml
│  │  │  │  ├─ values-bn/strings.xml
│  │  │  │  └─ values-hi/strings.xml
│  │  │  └─ AndroidManifest.xml
│  │  └─ test/
│  ├─ build.gradle
│  └─ proguard-rules.pro
├─ build.gradle
├─ settings.gradle
└─ gradle.properties
```

## AndroidIDE এ নির্মাণের ধাপসমূহ

সম্পূর্ণ বিস্তারিত নির্দেশনার জন্য SETUP_GUIDE_BN.md দেখুন।

## ভাষা সমর্থন
- English (en)
- বাংলা (bn)
- हिन्दी (hi)

## লাইসেন্স
MIT License - বিনামূল্যে ব্যবহার করুন এবং সংশোধন করুন।

## মেরামত এবং সহায়তা
সমস্যা হলে:
1. AndroidIDE পুনরায় শুরু করুন
2. Gradle ক্যাশ পরিষ্কার করুন
3. প্যাকেজ নাম পরীক্ষা করুন
4. জাভা সংস্করণ নিশ্চিত করুন (Java 17+)
