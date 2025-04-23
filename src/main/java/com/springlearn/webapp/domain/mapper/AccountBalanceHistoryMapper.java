package com.springlearn.webapp.domain.mapper;
// package io.backofficeservice.module.accountBalanceHistory.mapper;

// import io.backofficeservice.domain.AccountBalanceHistory;
// import io.backofficeservice.domain.JournalEntry;
// import io.backofficeservice.module.account.utils.AccountBalanceHistoryExcelColumn;
// import io.backofficeservice.module.accountBalanceHistory.dto.AccountBalanceHistoryDto;
// import io.backofficeservice.module.accountBalanceHistory.dto.BalanceHistoryDto;
// import io.backofficeservice.module.transaction.mapper.TransactionTypeMapping;
// import io.common.utils.StringHelper;
// import org.mapstruct.BeanMapping;
// import org.mapstruct.Context;
// import org.mapstruct.Mapper;
// import org.mapstruct.Mapping;
// import org.mapstruct.MappingConstants;
// import org.mapstruct.MappingTarget;
// import org.mapstruct.Named;
// import org.mapstruct.NullValuePropertyMappingStrategy;
// import org.mapstruct.ReportingPolicy;

// import java.time.Instant;
// import java.time.ZoneId;
// import java.util.Optional;
// import java.util.UUID;

// @Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
// public interface AccountBalanceHistoryMapper {

//     AccountBalanceHistory toEntity(AccountBalanceHistoryDto accountBalanceHistoryDto);

//     @Mapping(source = "journalEntry.id", target = "journalEntryId")
//     @Mapping(source = "journalEntry", target = "contraAccount", qualifiedByName = "contraAccountFormat")
//     @Mapping(source = "transaction.id", target = "transactionId", qualifiedByName = "getTransactionId")
//     @Mapping(source = "accountBalanceHistory", target = "description", qualifiedByName = "getDescription")
//     @Mapping(source = "journalEntry.sourceType", target = "journalEntrySource")
//     BalanceHistoryDto toDto(AccountBalanceHistory accountBalanceHistory, @Context String accountId, @Context UUID adjustmentTransId);

//     @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//     AccountBalanceHistory updateAccountBalanceHistoryFromAccountBalanceHistoryDto(AccountBalanceHistoryDto accountBalanceHistoryDto, @MappingTarget AccountBalanceHistory accountBalanceHistory);

//     @Mapping(target = "index", expression = "java(String.valueOf(index + 1))")
//     @Mapping(source = "accountBalanceHistory.createdAtUtc", target = "createdAtUtc", qualifiedByName = "toVNTimeZone")
//     @Mapping(source = "accountBalanceHistory.id", target = "transactionId")
//     @Mapping(source = "accountBalanceHistory.transactionType", target = "transactionType", qualifiedByName = "toVNTransactionType")
//     @Mapping(source = "accountBalanceHistory.journalEntry.id", target = "journalEntryId")
//     @Mapping(source = "accountBalanceHistory.description", target = "description")
//     @Mapping(source = "accountBalanceHistory.journalEntry", target = "contraAccount", qualifiedByName = "contraAccountFormat")
//     @Mapping(source = "accountBalanceHistory.balanceFluctuation", target = "balanceFluctuation", qualifiedByName = "toVNCurrency")
//     @Mapping(source = "accountBalanceHistory.currentBalance", target = "currentBalance", qualifiedByName = "toVNCurrency")
//     AccountBalanceHistoryExcelColumn toExcelColumn(AccountBalanceHistory accountBalanceHistory, int index, @Context String accountId);

//     @Named("toVNTimeZone")
//     default String toVNTimeZone(Instant utcTime) {
//         return StringHelper.formatDateTime(utcTime, ZoneId.of("Asia/Ho_Chi_Minh"));
//     }

//     @Named("toVNTransactionType")
//     default String toVNTransactionType(String transactionType) {
//         TransactionTypeMapping transactionTypeMapping = TransactionTypeMapping.getByValue(transactionType);
//         if (transactionTypeMapping != null) {
//             return transactionTypeMapping.getName();
//         }

//         return "";
//     }


//     @Named("contraAccountFormat")
//     default String contraAccountFormat(JournalEntry journalEntry, @Context String accountId) {
//         if (journalEntry != null) {
//             if (journalEntry.getFromAccount() != null) {
//                 if (accountId.equals(journalEntry.getFromAccount().getId())) {
//                     return Optional.ofNullable(journalEntry.getToAccount().getId()).orElse("");
//                 } else {
//                     return journalEntry.getFromAccount().getId();
//                 }
//             }
//         }
//         return "";
//     }

//     @Named("getTransactionId")
//     default String getTransactionId(String transactionId, @Context UUID adjustmentTransId) {
//         if (adjustmentTransId != null) return adjustmentTransId.toString();
//         if (transactionId != null) return transactionId;
//         return "";
//     }

//     @Named("getDescription")
//     default String getDescription(AccountBalanceHistory accountBalanceHistory) {
//         if (accountBalanceHistory.getAdjustmentTransaction() != null)
//             return accountBalanceHistory.getAdjustmentTransaction().getDescription();
//         if (accountBalanceHistory.getTransaction() != null)
//             return accountBalanceHistory.getTransaction().getDescription();
//         return "";
//     }

//     @Named("toVNCurrency")
//     default String toVNCurrency(Object amount) {
//         Long value = parseToLong(amount);
//         return value != null ? StringHelper.formatCurrency(value) : "";
//     }

//     private Long parseToLong(Object amount) {
//         if (amount == null) return null;

//         try {
//             if (amount instanceof Long) {
//                 return (Long) amount;
//             } else if (amount instanceof Integer) {
//                 return ((Integer) amount).longValue();
//             } else if (amount instanceof Double) {
//                 return ((Double) amount).longValue();
//             } else if (amount instanceof String) {
//                 String cleaned = ((String) amount).replaceAll(",", "").trim();
//                 if (cleaned.contains(".")) {
//                     double d = Double.parseDouble(cleaned);
//                     return (long) d;
//                 } else {
//                     return Long.parseLong(cleaned);
//                 }
//             } else {
//                 return Long.parseLong(amount.toString());
//             }
//         } catch (NumberFormatException e) {
//             return null;
//         }
//     }

// }