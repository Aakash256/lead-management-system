package com.business.manager.common.constant;

public enum ApplicationPropertyEnum {
  CLOUD("cloud", "AWS"),
  LAB_COST_UNIT("lab.cost.unit", "hour"),
  LAB_DEFAULT_DURATION_IN_MINUTES("lab.default.duration.in.minutes", "5"),
  LAB_DESTROYER_TIME_INTERVAL_IN_MINUTES("lab.destroyer.time.interval.in.minutes", "10"),
  TRAINING_DESTROYER_TIME_INTERVAL_IN_MINUTES("training.destroyer.time.interval.in.minutes", "60"),
  ALLOWED_LABS_PER_USER_IP("allowed.labs.per.userip", "10"),
  STATIC_DATA_REFRESHER_TIME_INTERVAL_IN_MINUTES(
      "static.data.refresher.time.interval.in.minutes", "30"),
  AWS_MAX_INSTANCE_COUNT("aws.max.instance.count", "20"),
  AWS_HOST("aws.host", "svadhyatapas.com"),

  AWS_LIGHTSAIL_AVAILABILITY_ZONE("aws.lightsail.availability.zone", "us-east-1a"),
  AWS_LIGHTSAIL_BUNDLE_ID("aws.lightsail.bundle.id", "micro_2_0"),
  AWS_LIGHTSAIL_INSTANCE_DEFAULT_SNAPSHOT(
      "aws.lightsail.instance.default.snapshot", "snapshot-us-east-1a-01"),

  AWS_LIGHTSAIL_INSTANCE_LOAD_FACTOR("aws.lightsail.instance.loadfactor", "0.85"),
  AWS_LIGHTSAIL_INSTANCE_DEFAULT_COUNT("aws.lightsail.instance.default.count", "4"),
  AWS_LIGHTSAIL_INSTANCE_MULTIPLIER("aws.lightsail.instance.multiplier", "1.25"),

  AWS_LIGHTSAIL_BLUEPRINT_ID("aws.lightsail.blueprint.id", "ubuntu_18_04"),
  AWS_LIGHTSAIL_PPK_FILE_PATH(
      "aws.lightsail.ppk.file.path", "/home/ec2-user/config/lightsail-ap-south-east-1.ppk"),
  AWS_LIGHTSAIL_INSTANCE_USER_NAME("aws.lightsail.instance.user.name", "ubuntu"),

  AWS_ROUTE53_RECORD_SET_TYPE("aws.route53.record.set.type", "A"),
  AWS_ROUTE53_HOSTED_ZONE_ID("aws.route53.hosted.zone.id", "Z02012621845NES79CT36"),
  AWS_ROUTE53_RECORD_SET_TTL("aws.route53.record.set.ttl", "300"),
  INSUFFICIENT_WALLET_BALANCE_MANAGER_TIME_INETERVAL_IN_MINUTES(
      "insufficient.wallet.balance.manager.time.interval.in.minutes", "30"),
  SIGNUP_OFFER_AMOUNT("signup.offer.amount", "50");

  private final String key;

  private final String defaultValue;

  ApplicationPropertyEnum(String key, String defaultValue) {
    this.key = key;
    this.defaultValue = defaultValue;
  }

  public String getKey() {
    return key;
  }

  public String getDefaultValue() {
    return defaultValue;
  }
}
