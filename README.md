# Cleartrip Assignment

I have used following components for the application

1.Implemented Dagger for dependency injection which promotes loose coupling(Lesser dependencies between components)
2.Retrofit for accessing webservice(A http library)
3.Used Dagger 2.0 for dependency injection
4.Picasso for dynamic Image loading and caching images
5.Gson for json parsing
6.Other UI components such as recyclerview,appcompat,v4 and v7 support libraries


Architecture Of CleartripAssignment Application

This application follows MVP architecture i.e Model View Presenter.
There are three main modules that are present in the application

UI(or View)(CleartripHomeActivity)
Presenter(CleartripHomePresenter)
Repository(CleartripWebserviceInteractor)

Ui & Presenter:
A Presenter provides the data for a specific UI component , such as a CleartripHomeActivity and handles the
communication with the business part of data handling, such as calling other components(namely CleartripWebserviceInteractor) to load the
data.I have followed package by feature approach for UI modules to easily segregate between screens

CleartripWebserviceInteractor & model:
Presenter could have  directly called the 1aim Webservice to fetch the data and assign it back to the user object.
Even though it works, the  app will be difficult to maintain as it grows. It gives too much responsibility
to the Presenter class which goes against the principle of separation of concerns.Instead, our Presenter
will delegate this work to a new CleartripWebserviceInteractor module.CleartripWebserviceInteractor modules are responsible
for handling data operations. They provide a clean API to the rest of the app.It uses
retrofit to communicate to the server and parse the data into respective model objects.

The CleartripWebserviceInteractor repository module can also  be extended to accommodate persisting data by following DAO pattern.

Other Supporting Modules or Packages:
api module : For Supporting Retrofit Module
model: contains all the POJO objects used in the application


**Improvements to be made to the app in the next version:**
1.Use RxJava
2.To Start converting the code to kotlin to leverage several advantages of kotlin
