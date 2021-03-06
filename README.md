# JaxWsExample
example of service development

**Что такое веб-сервисы?**

**Веб-сервисы** - это клиентские и серверные приложения, которые обмениваются данными по протоколу гипертекста (HTTP) World Wide Web (WWW). Как описывает Консорциум World Wide Web (W3C), веб-сервисы предоставляют стандартные средства взаимодействия между программными приложениями, работающими на различных платформах и платформах. Благодаря использованию XML веб-сервисы характеризуются высокой функциональной совместимостью и расширяемостью, а также их машинно-обрабатываемыми описаниями. Веб-службы могут быть объединены в слабосвязанной форме для выполнения сложных операций. Программы, предоставляющие простые услуги, могут взаимодействовать друг с другом для предоставления сложных дополнительных услуг.

**Типы веб-сервисов**

На концептуальном уровне услуга - это программный компонент, предоставляемый через доступную для сети конечную точку. Потребитель и поставщик услуг используют сообщения для обмена запросами на запрос и информацией об ответах в форме автономных документов, которые делают очень мало предположений о технологических возможностях получателя.

На техническом уровне веб-сервисы могут быть реализованы различными способами. Два типа веб-сервисов, обсуждаемые в этом разделе, можно различить как «большие» веб-сервисы и «RESTful» веб-сервисы.

**"Большие» веб-сервисы"**


   В Java EE 6 JAX-WS предоставляет функциональные возможности для «больших» веб-служб. Крупные веб-службы используют сообщения XML, соответствующие стандарту протокола SOAP (**Simple Object Access Protocol — простой протокол доступа к объектам**), язык XML, определяющий архитектуру и форматы сообщений. Такие системы часто содержат машиночитаемое описание операций, предлагаемых службой, написанное на языке описания веб-служб (WSDL), языке XML для синтаксического определения интерфейсов.

   Формат сообщения SOAP и язык определения интерфейса WSDL получили широкое распространение. Многие инструменты разработки, такие как IDE NetBeans, могут снизить сложность разработки приложений веб-служб.

   Проект на основе SOAP должен включать следующие элементы.

   Должен быть установлен официальный договор для описания интерфейса, предлагаемого веб-службой. WSDL может использоваться для описания деталей контракта, которые могут включать в себя сообщения, операции, привязки и местоположение веб-службы. Вы также можете обрабатывать сообщения SOAP в службе JAX-WS без публикации WSDL.

   Архитектура должна соответствовать сложным нефункциональным требованиям. Многие спецификации веб-сервисов отвечают этим требованиям и устанавливают для них общий словарь. Примеры включают транзакции, безопасность, адресацию, доверие, координацию и так далее.

   Архитектура должна обрабатывать асинхронную обработку и вызов. В таких случаях инфраструктура, обеспечиваемая стандартами, такими как надежные сообщения веб-служб (WSRM), и API-интерфейсы, такие как JAX-WS, с их поддержкой асинхронного вызова на стороне клиента, могут быть использованы сразу после установки.
