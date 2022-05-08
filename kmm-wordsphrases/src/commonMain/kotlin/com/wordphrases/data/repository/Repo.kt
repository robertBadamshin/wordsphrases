package com.wordphrases.data.repository

import com.wordphrases.data.model.FirebaseUserRemote
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore

class FirebaseRepository {

//    /***********************************************************************************************
//     * GET USERS FROM FIREBASE
//     **********************************************************************************************/
//    suspend fun getFirebaseUserList(): Response<List<FirebaseUserRemote>> {
//        var list = getListFromFirebase()
//        return Response.Success(list)
//    }

    suspend fun getListFromFirebase() {
        val reponse = Firebase.firestore
            .collection("Users")
            .add(FirebaseUserRemote("124"))
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