package com.wordphrases.data.repository

import com.wordphrases.data.model.*
import com.wordphrases.data.repository.datasource.*
import com.wordphrases.di.DataSourceProvider
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore

class FirebaseRepository(
    private val wordLocalDataSource: WordLocalDataSource = DataSourceProvider.wordLocalDataSource,
) {

//    /***********************************************************************************************
//     * GET USERS FROM FIREBASE
//     **********************************************************************************************/
//    suspend fun getFirebaseUserList(): Response<List<FirebaseUserRemote>> {
//        var list = getListFromFirebase()
//        return Response.Success(list)
//    }

    suspend fun getListFromFirebase() {
        val wordsForSync = wordLocalDataSource.getWordsForSync()

        val remoteWords = wordsForSync
            .map { wordDbEntity ->
                WordFirebaseRemote(
                    wordId = wordDbEntity.wordId,
                    createdAt = wordDbEntity.createdAt,
                    wordText = wordDbEntity.wordText,
                    repeatCount = wordDbEntity.repeatCount,
                    maxRepeatCount = wordDbEntity.maxRepeatCount,
                )
            }


//        val reponse = Firebase.firestore
//            .collection("Words")
//            .add(FirebaseUserRemote("124"))
    }

//
//    private fun parseFirebaseUserList(documentSnapshots: List<DocumentSnapshot>): List<FirebaseUserRemote> {
//        return documentSnapshots.map {
//            parseFirebaseUser(it)
//        }
//    }
//
//    private fun parseFirebaseUser(documentSnapshot: DocumentSnapshot): FirebaseUserRemote {
//        val level = documentSnapshot.data<>()
//        @Suppress("UNCHECKED_CAST")
//        val name = level?.get("name") as String
//        return FirebaseUserRemote(name)
//    }
//
//    /***********************************************************************************************
//     * GET USERS FROM FIREBASE FLOW
//     **********************************************************************************************/
//    suspend fun getDiscoverFlow() = flow {
//        emit(getFirebaseUserList())
//    }
//
//    /***********************************************************************************************
//     * CREATE USER
//     **********************************************************************************************/
//    suspend fun createUser() : Response<List<FirebaseUserRemote>> {
//        val userMap = mutableMapOf<String, String>()
//        userMap.put("DOCUMENT_USER_NAME", "request.firebaseUser.name")
//        getFirebaseInstance().collection(COLLECTION_USERS).suspendAdd(userMap)
//
//        return getFirebaseUserList()
//    }
}